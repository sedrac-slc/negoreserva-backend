package com.negoreserva.common.feature.concrete.role.repository;

import com.negoreserva.common.feature.concrete.role.model.Role;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends ConcreteRepository<Role> {
    Optional<Role> findByName(String name);
    Optional<Role> findByCode(String code);
}
