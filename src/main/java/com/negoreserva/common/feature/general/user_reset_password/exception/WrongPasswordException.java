package com.negoreserva.common.feature.general.user_reset_password.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("Current password is incorrect");
    }
}
