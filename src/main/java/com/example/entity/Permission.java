package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission {

    USER_READ("admin.roles.ro"),
    USER_WRITE("admin.roles.rw"),
    USER_DELETE("admin.remove_user.rw");


    private final String permission;

}
