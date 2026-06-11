package com.negoreserva.common.feature.concrete.user.exception.notfound;

import com.negoreserva.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(UUID uuid) {
        super("User not found by %s".formatted(uuid));
    }

    public UserNotFoundException(long id) {
        super("User not found by %s".formatted(id));
    }
}
