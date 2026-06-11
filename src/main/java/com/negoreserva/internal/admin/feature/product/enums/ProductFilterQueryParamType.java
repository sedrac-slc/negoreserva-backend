package com.negoreserva.internal.admin.feature.product.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ProductFilterQueryParamType {
    ALL("ALL"),
    NAME("NAME"),
    DESCRIPTION("DESCRIPTION"),
    TYPE("TYPE");

    private final String value;

    ProductFilterQueryParamType(String value) {
        this.value = value;
    }

    public static ProductFilterQueryParamType fromValue(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseGet(() -> ALL);
    }
}