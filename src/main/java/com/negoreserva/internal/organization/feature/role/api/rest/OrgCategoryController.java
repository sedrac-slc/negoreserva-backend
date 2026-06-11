package com.negoreserva.internal.organization.feature.role.api.rest;

import com.negoreserva.common.feature.concrete.category.dto.queryparam.CategoryFilterQueryParam;
import com.negoreserva.common.feature.concrete.category.dto.response.CategoryPaginate;
import com.negoreserva.common.feature.concrete.category.dto.response.CategoryResponse;
import com.negoreserva.common.feature.concrete.category.dto.request.CategoryRequest;
import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.internal.organization.feature.role.service.OrgCategoryService;
import com.negoreserva.internal.organization.feature.role.util.OrgRoleRouteNamed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(OrgRoleRouteNamed.PATH)
@Tag(name = "Org - Category", description = "Endpoints for categories management")
public class OrgCategoryController {

    private final OrgCategoryService service;

    @GetMapping
    @Operation(summary = "Get all categories")
    public ResponseEntity<CategoryPaginate> findAll(@ParameterObject Pageable page) {
        return ResponseEntity.ok(service.paginate(page));
    }

    @GetMapping(OrgRoleRouteNamed.FILTER)
    @Operation(summary = "Get categories by filter")
    public ResponseEntity<CategoryPaginate> findByFilter(@ParameterObject @ModelAttribute CategoryFilterQueryParam filter) {
        return ResponseEntity.ok(service.paginate(filter));
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Get category by uuid")
    public ResponseEntity<CategoryResponse> findByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid).toResponse());
    }

    @PostMapping
    @Operation(summary = "Create category")
    public ResponseEntity<CategoryResponse> save(@RequestBody @Valid CategoryRequest categoryDto) {
        Category category = service.save(categoryDto.toModel());
        return new ResponseEntity<>(category.toResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @Operation(summary = "Update category")
    public ResponseEntity<CategoryResponse> update(@PathVariable UUID uuid, @RequestBody @Valid CategoryRequest categoryDto) {
        Category category = service.update(uuid, categoryDto.toModel());
        return new ResponseEntity<>(category.toResponse(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Delete category by uuid")
    public ResponseEntity<Void> deleteByUuid(@PathVariable UUID uuid) {
        service.deleteByUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}