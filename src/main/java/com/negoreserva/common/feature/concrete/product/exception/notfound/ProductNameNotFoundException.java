package com.negoreserva.common.feature.concrete.product.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNameNotFoundException extends ProductNotFoundException {
    public ProductNameNotFoundException() {
        super("Product not found by name");
    }

    public ProductNameNotFoundException(String name) {
        super("Product not found by name %s".formatted(name));
    }
}