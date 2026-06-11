package com.negoreserva.internal.organization.feature.user.api.graphql;

import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.internal.organization.feature.user.dto.request.OrgUserCreateRequest;
import com.negoreserva.internal.organization.feature.user.dto.request.OrgUserUpdateRequest;
import com.negoreserva.internal.organization.feature.user.dto.response.OrgUserPaginate;
import com.negoreserva.internal.organization.feature.user.dto.response.OrgUserResponse;
import com.negoreserva.internal.organization.feature.user.service.OrgUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class OrgUserResolver {
    private final OrgUserService service;

    @QueryMapping
    public OrgUserPaginate orgPaginatePerson(@Argument PaginateRequest paginateRequest, Authentication authentication) {
        return service.paginate(paginateRequest, authentication);
    }

    @QueryMapping
    public OrgUserResponse orgFindByUuidPerson(@Argument String uuid) {
        return OrgUserResponse.of(service.findByUuid(UUID.fromString(uuid)));
    }

    @MutationMapping
    public OrgUserResponse orgSavePerson(@Argument @Valid OrgUserCreateRequest personCreateRequest, Authentication authentication) {
        return OrgUserResponse.of(service.create(personCreateRequest.toModel(), personCreateRequest.roleUuid(), authentication));
    }

    @MutationMapping
    public OrgUserResponse orgUpdatePerson(@Argument String uuid, @Argument @Valid OrgUserUpdateRequest personUpdateRequest) {
        return OrgUserResponse.of(service.update(UUID.fromString(uuid), personUpdateRequest.toModel()));
    }

    @MutationMapping
    public boolean orgDeleteByUuidPerson(@Argument String uuid) {
        service.deleteByUuid(UUID.fromString(uuid));
        return true;
    }
}
