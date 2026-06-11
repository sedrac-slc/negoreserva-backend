package com.negoreserva.internal.organization.feature.organization.dto.response;

import java.util.UUID;

public record OrgUserResponse(
        UUID uuid,
        String username,
        String name,
        String email,
        String phone
) { }
