package com.negoreserva.common.feature.concrete.role.service;

import com.negoreserva.common.feature.concrete.role.model.Role;
import com.negoreserva.common.feature.concrete.role.repository.RoleDao;
import com.negoreserva.common.feature.core.service.ConcreteService;
import org.springframework.stereotype.Service;


@Service
public class RoleFacade extends ConcreteService<Role> {
    private final RoleDao repository;

    public RoleFacade(RoleDao repository) {
        super(repository);
        this.repository = repository;
    }

    public Role findOrCreate(Role role) {
        return repository.findByName(role.getName()).orElseGet(() -> repository.save(role));
    }
}
