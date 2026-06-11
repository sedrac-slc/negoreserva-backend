package com.negoreserva.internal.organization.feature.organization.exception;

public class UserWithoutOrganizationException extends RuntimeException {
    public UserWithoutOrganizationException() {
        super("User without organization");
    }

    public UserWithoutOrganizationException(String message) {
        super(message);
    }
}
