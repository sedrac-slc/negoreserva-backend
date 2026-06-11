package com.negoreserva.internal.admin.feature.role.api.graphql;

import com.negoreserva.common.feature.concrete.role.dto.queryparam.RoleFilterQueryParam;
import com.negoreserva.common.feature.concrete.role.dto.request.RoleRequest;
import com.negoreserva.common.feature.concrete.role.dto.response.RolePaginate;
import com.negoreserva.common.feature.concrete.role.dto.response.RoleResponse;
import com.negoreserva.internal.admin.feature.role.service.AdminRoleService;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class AdminRoleResolver {
    private final AdminRoleService service;

    public AdminRoleResolver(AdminRoleService service) {
        this.service = service;
    }

    @QueryMapping
    public RoleResponse adminFindByUuidRole(@Argument UUID uuid) {
        return service.findByUuid(uuid).toResponse();
    }

    @QueryMapping
    public RoleResponse adminFindByNameRole(@Argument String name) {
        return service.findByName(name).toResponse();
    }

    @QueryMapping
    public RolePaginate adminPaginateRole(@Argument PaginateRequest paginateRequest) {
        return service.paginate(paginateRequest);
    }

    @QueryMapping
    public RolePaginate adminPaginateRoleFilter(@Argument RoleFilterQueryParam filter) {
        return service.paginate(filter);
    }

    @MutationMapping
    public RoleResponse adminSaveRole(@Argument @Valid RoleRequest roleRequest) {
        return service.save(roleRequest.toModel()).toResponse();
    }

    @MutationMapping
    public RoleResponse adminUpdateRole(@Argument UUID uuid, @Argument @Valid RoleRequest roleRequest) {
        return service.update(uuid, roleRequest.toModel()).toResponse();
    }

    @MutationMapping
    public boolean adminDeleteByUuidRole(@Argument UUID uuid) {
        service.deleteByUuid(uuid);
        return true;
    }
}
