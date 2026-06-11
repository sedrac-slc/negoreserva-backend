package com.negoreserva.common.feature.concrete.user.exception.unique;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserPhoneAlreadyExistsException extends RuntimeException {
    public UserPhoneAlreadyExistsException() {
        super("User exists email");
    }

    public UserPhoneAlreadyExistsException(String message) {
        super("User exists email %s".formatted(message));
    }
}
