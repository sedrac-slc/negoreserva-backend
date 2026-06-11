package com.negoreserva.common.feature.concrete.address.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum AddressFilterQueryParamType {
    ALL("ALL"),
    COUNTRY("COUNTRY"),
    STATE("STATE"),
    CITY("CITY"),
    STREET("STREET"),
    ZIP_CODE("ZIP_CODE");

    private final String value;

    public static AddressFilterQueryParamType fromValue(String value) {
        return Arrays.stream(values())
                .filter(it -> it.value.equals(value))
                .findFirst()
                .orElse(ALL);
    }
}
