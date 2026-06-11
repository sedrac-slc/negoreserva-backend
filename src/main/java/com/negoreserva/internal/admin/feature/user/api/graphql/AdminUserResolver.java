package com.negoreserva.internal.admin.feature.user.api.graphql;

import com.negoreserva.common.feature.concrete.user.dto.queryparam.UserFilterQueryParam;
import com.negoreserva.common.feature.concrete.user.dto.request.post.UserCreateRequest;
import com.negoreserva.common.feature.concrete.user.dto.request.put.UserUpdateRequest;
import com.negoreserva.common.feature.concrete.user.dto.response.UserPaginate;
import com.negoreserva.common.feature.concrete.user.dto.response.UserResponse;
import com.negoreserva.internal.admin.feature.user.service.AdminUserService;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class AdminUserResolver {
    private final AdminUserService service;

    public AdminUserResolver(AdminUserService service) {
        this.service = service;
    }

    @QueryMapping
    public UserResponse adminFindByUuidUser(@Argument String uuid) {
        return service.findByUuid(UUID.fromString(uuid)).toResponse();
    }

    @QueryMapping
    public UserPaginate adminPaginateUser(@Argument PaginateRequest paginateRequest) {
        return service.paginate(paginateRequest);
    }

    @QueryMapping
    public UserPaginate adminPaginateUserFilter(@Argument UserFilterQueryParam filter) {
        return service.paginate(filter);
    }

    @MutationMapping
    public UserResponse adminSaveUser(@Argument @Valid UserCreateRequest userCreateRequest) {
        return service.save(userCreateRequest.toModel()).toResponse();
    }

    @MutationMapping
    public UserResponse adminUpdateUser(@Argument String uuid, @Argument @Valid UserUpdateRequest userUpdateRequest) {
        return service.update(UUID.fromString(uuid), userUpdateRequest.toModel()).toResponse();
    }

    @MutationMapping
    public boolean adminDeleteByUuidUser(@Argument String uuid) {
        service.deleteByUuid(UUID.fromString(uuid));
        return true;
    }
}