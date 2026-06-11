package com.negoreserva.internal.organization.feature.role.api.graphql;

import com.negoreserva.common.feature.concrete.category.dto.queryparam.CategoryFilterQueryParam;
import com.negoreserva.common.feature.concrete.category.dto.request.CategoryRequest;
import com.negoreserva.common.feature.concrete.category.dto.response.CategoryPaginate;
import com.negoreserva.common.feature.concrete.category.dto.response.CategoryResponse;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.internal.organization.feature.role.service.OrgCategoryService;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class OrgCategoryResolver {
    private final OrgCategoryService service;

    public OrgCategoryResolver(OrgCategoryService service) {
        this.service = service;
    }

    @QueryMapping
    public CategoryResponse orgFindByUuidCategory(@Argument UUID uuid) {
        return service.findByUuid(uuid).toResponse();
    }

    @QueryMapping
    public CategoryPaginate orgPaginateCategory(@Argument PaginateRequest paginateRequest) {
        return service.paginate(paginateRequest);
    }

    @QueryMapping
    public CategoryPaginate orgPaginateCategoryFilter(@Argument CategoryFilterQueryParam filter) {
        return service.paginate(filter);
    }

    @MutationMapping
    public CategoryResponse orgSaveCategory(@Argument @Valid CategoryRequest categoryRequest) {
        return service.save(categoryRequest.toModel()).toResponse();
    }

    @MutationMapping
    public CategoryResponse orgUpdateCategory(@Argument UUID uuid, @Argument @Valid CategoryRequest categoryRequest) {
        return service.update(uuid, categoryRequest.toModel()).toResponse();
    }

    @MutationMapping
    public boolean orgDeleteByUuidCategory(@Argument UUID uuid) {
        service.deleteByUuid(uuid);
        return true;
    }
}