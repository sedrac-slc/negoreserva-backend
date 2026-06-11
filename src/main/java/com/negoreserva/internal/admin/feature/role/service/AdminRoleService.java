package com.negoreserva.internal.admin.feature.role.service;

import com.negoreserva.common.feature.concrete.role.dto.queryparam.RoleFilterQueryParam;
import com.negoreserva.common.feature.concrete.role.dto.response.RolePaginate;
import com.negoreserva.common.feature.concrete.role.exception.notfound.RoleCodeNotFoundException;
import com.negoreserva.common.feature.concrete.role.exception.notfound.RoleNameNotFoundException;
import com.negoreserva.common.feature.concrete.role.exception.notfound.RoleNotFoundException;
import com.negoreserva.common.feature.concrete.role.model.Role;
import com.negoreserva.common.feature.concrete.role.query.RoleFilterSpecification;
import com.negoreserva.internal.admin.feature.role.repository.AdminRoleRepository;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.common.feature.core.service.ConcreteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminRoleService extends ConcreteService<Role> {
    private final AdminRoleRepository repository;

    public AdminRoleService(AdminRoleRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public RolePaginate paginate(Pageable pageable) {
        var page = repository.findAll(pageable);
        return RolePaginate.of(page);
    }

    public RolePaginate paginate(PaginateRequest paginateRequest) {
        return paginate(PageRequest.of(paginateRequest.pageNumber(), paginateRequest.pageSize()));
    }

    public RolePaginate paginate(RoleFilterQueryParam filter) {
        var pageRequest = PageRequest.of(
                Optional.of(filter.getPageNumber()).orElse(0),
                Optional.of(filter.getPageSize()).orElse(10)
        );
        var spec = new RoleFilterSpecification(filter);
        var page = findAll(spec, pageRequest);
        return RolePaginate.of(page);
    }

    public Role findByUuid(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new RoleNotFoundException(uuid));
    }

    public Role findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new RoleNameNotFoundException(name));
    }

    public Role findByCode(String code) {
        return repository.findByCode(code).orElseThrow(() -> new RoleCodeNotFoundException(code));
    }

    public Role findOrCreate(Role role) {
        return repository.findByName(role.getName()).orElseGet(() -> repository.save(role));
    }
}
