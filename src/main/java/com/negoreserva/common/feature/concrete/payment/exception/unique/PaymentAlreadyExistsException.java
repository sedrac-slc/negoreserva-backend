package com.negoreserva.common.feature.concrete.payment.exception.unique;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PaymentAlreadyExistsException extends RuntimeException {
    public PaymentAlreadyExistsException() { super("Payment already exists"); }
    public PaymentAlreadyExistsException(String message) { super(message); }
}
