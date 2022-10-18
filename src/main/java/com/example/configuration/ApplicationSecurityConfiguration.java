package com.example.configuration;

import com.example.entity.Permission;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class ApplicationSecurityConfiguration {

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   SecurityFilter securityFilter) {
        //mechanism for protection verificaton html page
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET).hasAnyAuthority(Permission.USER_DELETE.getPermission(),Permission.USER_WRITE.getPermission(),Permission.USER_READ.getPermission())
                .antMatchers(HttpMethod.POST).hasAnyAuthority(Permission.USER_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE).hasAnyAuthority(Permission.USER_DELETE.getPermission())
                //.antMatchers("/entry/registration", "/login", "/public").permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}