package com.negoreserva.common.feature.concrete.role.dto.response;

import java.util.UUID;

public record RoleResponse(UUID uuid, String code, String name, String description, String roleType) { }
