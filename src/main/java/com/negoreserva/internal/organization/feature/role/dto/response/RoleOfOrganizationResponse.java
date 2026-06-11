package com.negoreserva.internal.organization.feature.role.dto.response;

import java.util.UUID;

public record RoleOfOrganizationResponse(
        UUID uuid,
        String name,
        String description
) { }