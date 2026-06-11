package com.negoreserva.internal.organization.feature.dashboard.dto.response;

import java.util.UUID;

public record DashboardCatalogWithProductCount(
    UUID uuid,
    String name,
    String description,
    String imgUrl,
    String slug,
    int productCount
) {}
