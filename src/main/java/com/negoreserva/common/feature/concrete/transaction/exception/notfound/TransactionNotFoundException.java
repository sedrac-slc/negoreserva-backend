package com.negoreserva.common.feature.concrete.transaction.exception.notfound;

import com.negoreserva.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends NotFoundException {
    public TransactionNotFoundException() { super("Transaction not found"); }
    public TransactionNotFoundException(String message) { super(message); }
    public TransactionNotFoundException(UUID uuid) { super("Transaction not found by uuid %s".formatted(uuid)); }
}
