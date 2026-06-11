package com.negoreserva.common.feature.concrete.organization.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizationNameNotFoundException extends OrganizationNotFoundException {
    public OrganizationNameNotFoundException() {
        super("Organization not found by name");
    }

    public OrganizationNameNotFoundException(String name) {
        super("Organization not found by name %s".formatted(name));
    }
}