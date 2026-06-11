package com.negoreserva.internal.organization.feature.permission.repository;

import com.negoreserva.common.feature.concrete.org_permission.model.OrgPermission;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgPermissionRepository extends ConcreteRepository<OrgPermission> {
    Optional<OrgPermission> findByName(String name);
}
