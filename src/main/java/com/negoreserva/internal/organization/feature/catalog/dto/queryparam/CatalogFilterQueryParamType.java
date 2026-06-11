package com.negoreserva.internal.organization.feature.catalog.dto.queryparam;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CatalogFilterQueryParamType {
    ALL("ALL"),
    NAME("NAME"),
    DESCRIPTION("DESCRIPTION");

    private final String value;

    CatalogFilterQueryParamType(String value) {
        this.value = value;
    }

    public static CatalogFilterQueryParamType fromValue(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseGet(() -> ALL);
    }
}
