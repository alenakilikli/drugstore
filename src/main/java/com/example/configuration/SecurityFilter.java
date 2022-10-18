package com.example.configuration;

import com.example.entity.AccountSession;
import com.example.entity.Role;
import com.example.repository.SessionRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecurityFilter  extends OncePerRequestFilter {


    private SessionRepository sessionRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header == null) {
            filterChain.doFilter(request, response);
            return;
        }


        AccountSession accountSession = sessionRepository.findBySessionId(header);
        if (accountSession == null) {
            filterChain.doFilter(request, response);
            return;
        }


        Authentication key = new UsernamePasswordAuthenticationToken(
                accountSession,
                null,
                new ArrayList<>()
                //roles.stream().map(x -> new SimpleGrantedAuthority(x.name())).toList()
        );
        SecurityContextHolder.getContext().setAuthentication(key);

        filterChain.doFilter(request, response);
    }
}
