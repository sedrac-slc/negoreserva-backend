package com.negoreserva.internal.organization.feature.dashboard.dto.response;

public record DashboardTotals(
    int totalProducts,
    int totalPayments,
    int totalCatalogs
) {}
