package com.negoreserva.common.feature.concrete.user.exception.unique;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserUsernameAlreadyExistsException extends RuntimeException {
    public UserUsernameAlreadyExistsException() {
        super("User exists username");
    }

    public UserUsernameAlreadyExistsException(String username) {
        super("User exists username %s".formatted(username));
    }
}
