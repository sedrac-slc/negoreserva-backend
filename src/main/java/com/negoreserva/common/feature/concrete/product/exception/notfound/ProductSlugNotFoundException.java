package com.negoreserva.common.feature.concrete.product.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductSlugNotFoundException extends ProductNotFoundException {

    public ProductSlugNotFoundException() {
        super("Product not found by slug");
    }

    public ProductSlugNotFoundException(String slug) {
        super("Product not found by slug %s".formatted(slug));
    }
}
