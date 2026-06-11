package com.negoreserva.common.feature.concrete.payment.exception.notfound;

import com.negoreserva.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends NotFoundException {
    public PaymentNotFoundException() { super("Payment not found"); }
    public PaymentNotFoundException(String message) { super(message); }
    public PaymentNotFoundException(UUID uuid) { super("Payment not found by uuid %s".formatted(uuid)); }
}
