package com.negoreserva.common.feature.concrete.role.model;

import com.negoreserva.common.feature.concrete.role.dto.request.RoleRequest;
import com.negoreserva.common.feature.concrete.role.dto.response.RoleResponse;
import com.negoreserva.common.variable.EntityVariable;
import com.negoreserva.common.feature.core.model.ConcreteModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = EntityVariable.ROLE)
public class Role extends ConcreteModel {
    @Column(updatable = false, unique = true)
    private String code;

    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public RoleResponse toResponse() {
        return new RoleResponse(uuid, code, name, description, roleType != null ? roleType.name() : null);
    }

    public RoleRequest toRoleRequest() {
        return new RoleRequest(code, name, description, roleType);
    }
}
