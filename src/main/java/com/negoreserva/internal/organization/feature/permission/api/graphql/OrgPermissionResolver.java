package com.negoreserva.internal.organization.feature.permission.api.graphql;

import com.negoreserva.common.feature.concrete.org_permission.dto.request.OrgPermissionRequest;
import com.negoreserva.common.feature.concrete.org_permission.dto.response.OrgPermissionPaginate;
import com.negoreserva.common.feature.concrete.org_permission.dto.response.OrgPermissionResponse;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.internal.organization.feature.permission.service.OrgPermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class OrgPermissionResolver {
    private final OrgPermissionService service;

    @QueryMapping
    public OrgPermissionPaginate orgPaginatePermission(@Argument PaginateRequest paginateRequest) {
        return service.paginate(paginateRequest);
    }

    @QueryMapping
    public OrgPermissionResponse orgFindByUuidPermission(@Argument String uuid) {
        return service.findByUuid(UUID.fromString(uuid)).toResponse();
    }

    @MutationMapping
    public OrgPermissionResponse orgSavePermission(@Argument @Valid OrgPermissionRequest permissionRequest) {
        return service.save(permissionRequest.toModel()).toResponse();
    }

    @MutationMapping
    public OrgPermissionResponse orgUpdatePermission(@Argument String uuid, @Argument @Valid OrgPermissionRequest permissionRequest) {
        return service.update(UUID.fromString(uuid), permissionRequest.toModel()).toResponse();
    }

    @MutationMapping
    public boolean orgDeleteByUuidPermission(@Argument String uuid) {
        service.deleteByUuid(UUID.fromString(uuid));
        return true;
    }
}
