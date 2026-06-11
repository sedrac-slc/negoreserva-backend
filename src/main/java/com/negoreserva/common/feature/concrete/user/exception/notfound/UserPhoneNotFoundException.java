package com.negoreserva.common.feature.concrete.user.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserPhoneNotFoundException extends UserNotFoundException {
    public UserPhoneNotFoundException() {
        super("User not found by phone");
    }

    public UserPhoneNotFoundException(String phone) {
        super("User not found by phone %s".formatted(phone));
    }
}
