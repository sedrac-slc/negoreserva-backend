package com.negoreserva.internal.organization.feature.payment.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PaymentFilterQueryParamType {
    ALL("ALL"),
    STATUS("STATUS"),
    TYPE("TYPE");

    private final String value;

    PaymentFilterQueryParamType(String value) {
        this.value = value;
    }

    public static PaymentFilterQueryParamType fromValue(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseGet(() -> ALL);
    }
}
