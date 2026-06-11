package com.negoreserva.common.feature.concrete.category.exception.unique;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CategoryNameAlreadyExistsException extends RuntimeException {
    public CategoryNameAlreadyExistsException() {
        super("Category exists with name");
    }

    public CategoryNameAlreadyExistsException(String name) {
        super("Category exists with name %s".formatted(name));
    }
}