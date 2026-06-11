package com.negoreserva.internal.organization.feature.role.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrgRoleFilterQueryParamType {
    ALL("ALL"),
    NAME("NAME"),
    DESCRIPTION("DESCRIPTION");

    private final String value;

    OrgRoleFilterQueryParamType(String value) {
        this.value = value;
    }

    public static OrgRoleFilterQueryParamType fromValue(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseGet(() -> ALL);
    }
}