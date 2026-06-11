package com.negoreserva.internal.organization.feature.role_permission.service;

import com.negoreserva.common.feature.concrete.org_permission.model.OrgPermission;
import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import com.negoreserva.common.feature.pivot.org_role_permission.model.OrgRolePermission;
import com.negoreserva.internal.organization.feature.role_permission.repository.OrgRolePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrgRolePermissionService {
    private final OrgRolePermissionRepository repository;

    @Transactional
    public void sync(OrgRole role, List<OrgPermission> permissions) {
        repository.deleteByRole(role);
        permissions.forEach(permission -> repository.save(OrgRolePermission.builder()
                .role(role)
                .permission(permission)
                .build()));
    }
}
