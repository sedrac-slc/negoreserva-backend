package com.negoreserva.internal.organization.feature.role.api.graphql;

import com.negoreserva.common.feature.concrete.org_role.dto.request.OrgRoleRequest;
import com.negoreserva.common.feature.concrete.org_role.dto.response.OrgRolePaginate;
import com.negoreserva.common.feature.concrete.org_role.dto.response.OrgRoleResponse;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.internal.organization.feature.role.service.OrgRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class OrgRoleResolver {
    private final OrgRoleService service;

    @QueryMapping
    public OrgRolePaginate orgPaginateRole(@Argument PaginateRequest paginateRequest) {
        return service.paginate(paginateRequest);
    }

    @QueryMapping
    public OrgRoleResponse orgFindByUuidRole(@Argument String uuid) {
        return service.findByUuid(UUID.fromString(uuid)).toResponse();
    }

    @MutationMapping
    public OrgRoleResponse orgSaveRole(@Argument @Valid OrgRoleRequest roleRequest) {
        return service.save(roleRequest).toResponse();
    }

    @MutationMapping
    public OrgRoleResponse orgUpdateRole(@Argument String uuid, @Argument @Valid OrgRoleRequest roleRequest) {
        return service.update(UUID.fromString(uuid), roleRequest).toResponse();
    }

    @MutationMapping
    public boolean orgDeleteByUuidRole(@Argument String uuid) {
        service.deleteByUuid(UUID.fromString(uuid));
        return true;
    }
}
