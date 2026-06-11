package com.negoreserva.internal.organization.feature.catalog.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CatalogProductOrderInput(
    @NotNull UUID productUuid,
    @NotNull @Min(1) Integer order
) {}
