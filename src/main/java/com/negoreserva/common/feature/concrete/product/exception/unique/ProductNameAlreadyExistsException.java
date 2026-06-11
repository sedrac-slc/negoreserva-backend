package com.negoreserva.common.feature.concrete.product.exception.unique;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductNameAlreadyExistsException extends RuntimeException {
    public ProductNameAlreadyExistsException() {
        super("Product exists with name");
    }

    public ProductNameAlreadyExistsException(String name) {
        super("Product exists with name %s".formatted(name));
    }
}