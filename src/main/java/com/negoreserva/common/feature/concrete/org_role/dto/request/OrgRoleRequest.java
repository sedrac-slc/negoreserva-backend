package com.negoreserva.common.feature.concrete.org_role.dto.request;

import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public record OrgRoleRequest(@NotBlank String name, String description, List<UUID> permissionUuids) {
    public OrgRole toModel() {
        return OrgRole.builder().name(name).description(description).build();
    }
}
