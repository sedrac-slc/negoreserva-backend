package com.negoreserva.common.feature.concrete.organization.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizationPhoneNotFoundException extends OrganizationNotFoundException {
    public OrganizationPhoneNotFoundException() {
        super("Organization not found by phone");
    }

    public OrganizationPhoneNotFoundException(String phone) {
        super("Organization not found by phone %s".formatted(phone));
    }
}