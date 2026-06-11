package com.negoreserva.internal.admin.feature.organization.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrganizationFilterQueryParamType {
    ALL("ALL"),
    NAME("NAME"),
    EMAIL("EMAIL"),
    PHONE("PHONE"),
    DESCRIPTION("DESCRIPTION"),
    ADDRESS("ADDRESS");

    private final String value;

    OrganizationFilterQueryParamType(String value) {
        this.value = value;
    }

    public static OrganizationFilterQueryParamType fromValue(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseGet(() -> ALL);
    }
}