package com.negoreserva.common.feature.concrete.organization.exception.notfound;

import com.negoreserva.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizationNotFoundException extends NotFoundException {
    public OrganizationNotFoundException() {
        super("Organization not found");
    }

    public OrganizationNotFoundException(String message) {
        super(message);
    }

    public OrganizationNotFoundException(UUID uuid) {
        super("Organization not found by uuid %s".formatted(uuid));
    }
}