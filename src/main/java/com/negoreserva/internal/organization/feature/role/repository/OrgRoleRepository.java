package com.negoreserva.internal.organization.feature.role.repository;

import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgRoleRepository extends ConcreteRepository<OrgRole> {
    Optional<OrgRole> findByName(String name);
}
