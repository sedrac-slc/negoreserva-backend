package com.negoreserva.common.feature.concrete.category.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CategoryFilterQueryParamType {
    ALL("ALL"),
    NAME("NAME"),
    DESCRIPTION("DESCRIPTION");

    private final String value;

    CategoryFilterQueryParamType(String value) {
        this.value = value;
    }

    public static CategoryFilterQueryParamType fromValue(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseGet(() -> ALL);
    }
}