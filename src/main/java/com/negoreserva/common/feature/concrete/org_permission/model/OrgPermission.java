package com.negoreserva.common.feature.concrete.org_permission.model;

import com.negoreserva.common.feature.concrete.org_permission.dto.request.OrgPermissionRequest;
import com.negoreserva.common.feature.concrete.org_permission.dto.response.OrgPermissionResponse;
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
@Table(name = EntityVariable.ORG_PERMISSION)
public class OrgPermission extends ConcreteModel {
    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;

    public OrgPermissionResponse toResponse() {
        return new OrgPermissionResponse(uuid, name, description);
    }

    public OrgPermissionRequest toRequest() {
        return new OrgPermissionRequest(name, description);
    }
}
