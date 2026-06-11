package com.negoreserva.common.feature.pivot.org_role_permission.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.negoreserva.common.feature.concrete.org_permission.model.OrgPermission;
import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import com.negoreserva.common.variable.EntityPivotVariable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(
        name = EntityPivotVariable.ORG_ROLE_PERMISSION,
        uniqueConstraints = {@UniqueConstraint(
                name = "uk_org_role_permission",
                columnNames = {"role_id", "permission_id"}
        )}
)
public class OrgRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private OrgRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", nullable = false)
    private OrgPermission permission;
}
