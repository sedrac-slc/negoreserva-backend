package com.negoreserva.internal.admin.feature.role.api.rest;

import com.negoreserva.common.feature.concrete.role.dto.queryparam.RoleFilterQueryParam;
import com.negoreserva.common.feature.concrete.role.dto.request.RoleRequest;
import com.negoreserva.common.feature.concrete.role.dto.response.RolePaginate;
import com.negoreserva.common.feature.concrete.role.dto.response.RoleResponse;
import com.negoreserva.common.feature.concrete.role.model.Role;
import com.negoreserva.internal.admin.feature.role.service.AdminRoleService;
import com.negoreserva.internal.admin.feature.role.util.RoleRouteNamed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(RoleRouteNamed.PATH)
@Tag(name = "Common - Role", description = "Endpoints for roles management")
public class AdminRoleController {

    private final AdminRoleService service;

    @GetMapping
    @Operation(summary = "Get all roles")
    public ResponseEntity<RolePaginate> findAll(@ParameterObject Pageable page) {
        return ResponseEntity.ok(service.paginate(page));
    }

    @GetMapping(RoleRouteNamed.FILTER)
    @Operation(summary = "Get roles by filter")
    public ResponseEntity<RolePaginate> findByFilter(@ParameterObject @ModelAttribute RoleFilterQueryParam filter) {
        return ResponseEntity.ok(service.paginate(filter));
    }

    @GetMapping(RoleRouteNamed.FIND_BY_NAME)
    @Operation(summary = "Get role by name")
    public ResponseEntity<RoleResponse> findByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name).toResponse());
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Get role by uuid")
    public ResponseEntity<RoleResponse> findByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid).toResponse());
    }

    @PostMapping
    @Operation(summary = "Create role")
    public ResponseEntity<RoleResponse> save(@RequestBody @Valid RoleRequest roleRequest) {
        Role role = service.save(roleRequest.toModel());
        return new ResponseEntity<>(role.toResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @Operation(summary = "Update role")
    public ResponseEntity<RoleResponse> update(@PathVariable UUID uuid, @RequestBody @Valid RoleRequest roleRequest) {
        Role role = service.update(uuid, roleRequest.toModel());
        return new ResponseEntity<>(role.toResponse(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Delete role by uuid")
    public ResponseEntity<Void> deleteByUuid(@PathVariable UUID uuid) {
        service.deleteByUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
