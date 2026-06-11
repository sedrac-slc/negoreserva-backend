package com.negoreserva.common.feature.concrete.address.exception.notfound;

import com.negoreserva.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends NotFoundException {
    public AddressNotFoundException() {
        super("Address not found");
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(UUID uuid) {
        super("Address not found by uuid %s".formatted(uuid));
    }
}
