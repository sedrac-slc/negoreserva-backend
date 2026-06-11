package com.negoreserva.common.feature.concrete.organization.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizationSlugNotFoundException extends OrganizationNotFoundException {
    public OrganizationSlugNotFoundException() {
        super("Organization not found by slug");
    }

    public OrganizationSlugNotFoundException(String slug) {
        super("Organization not found by slug %s".formatted(slug));
    }
}