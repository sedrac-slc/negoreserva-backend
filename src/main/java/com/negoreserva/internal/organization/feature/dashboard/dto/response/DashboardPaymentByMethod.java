package com.negoreserva.internal.organization.feature.dashboard.dto.response;

public record DashboardPaymentByMethod(
    String paymentMethod,
    long count
) {}
