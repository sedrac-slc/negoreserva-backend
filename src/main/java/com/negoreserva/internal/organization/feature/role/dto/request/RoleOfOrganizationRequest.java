package com.negoreserva.internal.organization.feature.role.dto.request;

import com.negoreserva.internal.organization.feature.role.model.RoleOfOrganization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RoleOfOrganizationRequest(
        @NotBlank
        @Size(max = 100)
        String name,
        @NotBlank
        @Size(max = 255)
        String description
) {
    public RoleOfOrganization toModel() {
        return RoleOfOrganization.builder()
                .name(name)
                .description(description)
                .build();
    }
}