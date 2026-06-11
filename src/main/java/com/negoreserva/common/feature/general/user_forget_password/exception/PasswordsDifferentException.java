package com.negoreserva.common.feature.general.user_forget_password.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
public class PasswordsDifferentException extends RuntimeException {

    public PasswordsDifferentException() {
        super("The passwords not equals");
    }

    public PasswordsDifferentException(String message) {
        super(message);
    }
}
