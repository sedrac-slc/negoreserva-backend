package com.negoreserva.common.feature.concrete.org_permission.dto.request;

import com.negoreserva.common.feature.concrete.org_permission.model.OrgPermission;
import jakarta.validation.constraints.NotBlank;

public record OrgPermissionRequest(@NotBlank String name, String description) {
    public OrgPermission toModel() {
        return OrgPermission.builder().name(name).description(description).build();
    }
}
