package com.negoreserva.internal.organization.feature.catalog.dto.response;

import com.negoreserva.common.feature.concrete.catalog.enums.CatalogType;
import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.organization.model.Organization;

import java.util.Optional;
import java.util.UUID;

public record OrgCatalogResponse(
    UUID uuid,
    String name,
    String description,
    String imgUrl,
    String slug,
    CatalogType type
) {
    public static OrgCatalogResponse toResponse(Catalog catalog) {
        var imageUrl = Optional.ofNullable(catalog.getImgUrl())
                .filter(url -> !url.isBlank())
                .or(() -> Optional.ofNullable(catalog.getOrganization()).map(Organization::getImage))
                .orElse(null);

        return new OrgCatalogResponse(
            catalog.getUuid(),
            catalog.getName(),
            catalog.getDescription(),
            imageUrl,
            catalog.getSlug(),
            catalog.getType()
        );
    }
}
