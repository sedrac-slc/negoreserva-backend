package com.negoreserva.internal.organization.feature.role_permission.repository;

import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import com.negoreserva.common.feature.pivot.org_role_permission.model.OrgRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRolePermissionRepository extends JpaRepository<OrgRolePermission, Long> {
    void deleteByRole(OrgRole role);
}
