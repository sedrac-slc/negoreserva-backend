package com.negoreserva.internal.organization.feature.role.model;

import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.internal.organization.feature.role.dto.request.RoleOfOrganizationRequest;
import com.negoreserva.internal.organization.feature.role.dto.response.RoleOfOrganizationResponse;
import com.negoreserva.internal.organization.util.OrgEntityNamed;
import com.negoreserva.common.feature.core.model.ConcreteModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Table(
        name = OrgEntityNamed.ROLE_OF_ORGANIZATION,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_code_organization",
                        columnNames = {"organization_id", "code"}
                )
        }
)
public class RoleOfOrganization extends ConcreteModel {
    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public RoleOfOrganizationResponse toResponse() {
        return new RoleOfOrganizationResponse(uuid, name, description);
    }

    public RoleOfOrganizationRequest toRequest() {
        return new RoleOfOrganizationRequest(name, description);
    }
}
