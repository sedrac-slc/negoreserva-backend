package com.negoreserva.common.feature.concrete.org_role.model;

import com.negoreserva.common.feature.concrete.org_role.dto.request.OrgRoleRequest;
import com.negoreserva.common.feature.concrete.org_role.dto.response.OrgRoleResponse;
import com.negoreserva.common.feature.core.model.ConcreteModel;
import com.negoreserva.common.variable.EntityVariable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = EntityVariable.ORG_ROLE)
public class OrgRole extends ConcreteModel {
    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;

    public OrgRoleResponse toResponse() {
        return new OrgRoleResponse(uuid, name, description);
    }

    public OrgRoleRequest toRequest() {
        return new OrgRoleRequest(name, description, null);
    }
}
