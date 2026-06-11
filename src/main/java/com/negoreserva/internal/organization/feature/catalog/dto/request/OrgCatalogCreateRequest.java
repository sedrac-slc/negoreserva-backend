package com.negoreserva.internal.organization.feature.catalog.dto.request;

import com.negoreserva.common.feature.concrete.catalog.enums.CatalogType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OrgCatalogCreateRequest(
    @NotBlank @Size(max = 100) String name,
    @NotBlank @Size(max = 255) String description,
    CatalogType type
) {}
