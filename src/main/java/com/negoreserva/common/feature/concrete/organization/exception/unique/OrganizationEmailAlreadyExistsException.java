package com.negoreserva.common.feature.concrete.organization.exception.unique;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OrganizationEmailAlreadyExistsException extends RuntimeException {
    public OrganizationEmailAlreadyExistsException() {
        super("Organization exists email");
    }

    public OrganizationEmailAlreadyExistsException(String email) {
        super("Organization exists email %s".formatted(email));
    }
}