package com.negoreserva.common.feature.concrete.user.exception.unique;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserEmailAlreadyExistsException extends RuntimeException {
    public UserEmailAlreadyExistsException() {
        super("User exists email");
    }

    public UserEmailAlreadyExistsException(String email) {
        super("User exists email %s".formatted(email));
    }
}
