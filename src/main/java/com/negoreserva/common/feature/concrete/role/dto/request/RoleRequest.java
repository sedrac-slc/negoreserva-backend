package com.negoreserva.common.feature.concrete.role.dto.request;

import com.negoreserva.common.feature.concrete.role.model.Role;
import com.negoreserva.common.feature.concrete.role.model.RoleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RoleRequest(
        @NotBlank
        @Size(max = 100)
        String code,
        @NotBlank
        @Size(max = 100)
        String name,
        @Size(max = 255)
        String description,
        RoleType roleType
) {
    public Role toModel() {
        return Role.builder()
                .code(code)
                .name(name)
                .description(description)
                .roleType(roleType)
                .build();
    }
}
