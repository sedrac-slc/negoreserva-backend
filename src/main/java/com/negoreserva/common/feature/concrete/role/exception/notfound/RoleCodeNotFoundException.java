package com.negoreserva.common.feature.concrete.role.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoleCodeNotFoundException extends RuntimeException {
    public RoleCodeNotFoundException(String code) {
        super("Role not found with code: " + code);
    }
}
