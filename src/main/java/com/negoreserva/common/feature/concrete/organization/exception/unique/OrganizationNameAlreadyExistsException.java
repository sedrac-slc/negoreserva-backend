package com.negoreserva.common.feature.concrete.organization.exception.unique;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OrganizationNameAlreadyExistsException extends RuntimeException {
    public OrganizationNameAlreadyExistsException() {
        super("Organization exists name");
    }

    public OrganizationNameAlreadyExistsException(String name) {
        super("Organization exists name %s".formatted(name));
    }
}