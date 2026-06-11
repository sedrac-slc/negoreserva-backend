package com.negoreserva.internal.organization.feature.dashboard.dto.response;

public record DashboardPaymentByStatus(
    String paymentStatus,
    long count
) {}
