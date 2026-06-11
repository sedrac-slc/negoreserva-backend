package com.negoreserva.common.feature.concrete.organization.exception.unique;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OrganizationPhoneAlreadyExistsException extends RuntimeException {
    public OrganizationPhoneAlreadyExistsException() {
        super("Organization exists phone");
    }

    public OrganizationPhoneAlreadyExistsException(String message) {
        super("Organization exists phone %s".formatted(message));
    }
}