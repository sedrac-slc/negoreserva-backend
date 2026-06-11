package com.negoreserva.common.feature.concrete.role.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoleNameNotFoundException extends RuntimeException {
    public RoleNameNotFoundException(String name) {
        super("Role not found with name: " + name);
    }
}
