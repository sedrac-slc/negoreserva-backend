package com.negoreserva.external.feature.organization.dto.response;

import com.negoreserva.common.feature.concrete.organization.model.Organization;

import java.util.UUID;

public record ExtOrganizationResponse(
        UUID uuid,
        String name,
        String slug,
        String description,
        String address,
        Integer rating,
        String logo,
        String image
) {
    public static ExtOrganizationResponse of(Organization organization) {
        return new ExtOrganizationResponse(
                organization.getUuid(),
                organization.getName(),
                organization.getSlug(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getRating(),
                organization.getLogo(),
                organization.getImage()
        );
    }
}
