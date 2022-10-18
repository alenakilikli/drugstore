package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Role {

    DOCTOR(Set.of(Permission.USER_DELETE, Permission.USER_WRITE, Permission.USER_READ)),
    DRUGSTORE(Set.of(Permission.USER_DELETE, Permission.USER_READ)),
    PATIENT(Set.of(Permission.USER_READ));

    private final Set<Permission> permissions;


    public Set<SimpleGrantedAuthority>getAuthorities(){
    return getPermissions().stream()
            .map(permission->new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toSet());
}
}
