package com.negoreserva.common.feature.concrete.user.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserUsernameNotFoundException extends UserNotFoundException {
    public UserUsernameNotFoundException() {
        super("User not found by username");
    }

    public UserUsernameNotFoundException(String username) {
        super("User not found by username %s".formatted(username));
    }
}
