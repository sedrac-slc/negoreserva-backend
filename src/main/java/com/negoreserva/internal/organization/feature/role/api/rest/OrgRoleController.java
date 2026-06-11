package com.negoreserva.internal.organization.feature.role.api.rest;

import com.negoreserva.common.feature.concrete.org_role.dto.request.OrgRoleRequest;
import com.negoreserva.common.feature.concrete.org_role.dto.response.OrgRolePaginate;
import com.negoreserva.common.feature.concrete.org_role.dto.response.OrgRoleResponse;
import com.negoreserva.internal.organization.feature.role.service.OrgRoleService;
import com.negoreserva.internal.organization.feature.role.util.OrgRoleCrudRouteNamed;
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
@RequestMapping(OrgRoleCrudRouteNamed.PATH)
public class OrgRoleController {
    private final OrgRoleService service;

    @GetMapping
    public ResponseEntity<OrgRolePaginate> findAll(@ParameterObject Pageable page) {
        return ResponseEntity.ok(service.paginate(page));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrgRoleResponse> findByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid).toResponse());
    }

    @PostMapping
    public ResponseEntity<OrgRoleResponse> save(@RequestBody @Valid OrgRoleRequest request) {
        return new ResponseEntity<>(service.save(request).toResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrgRoleResponse> update(@PathVariable UUID uuid, @RequestBody @Valid OrgRoleRequest request) {
        return new ResponseEntity<>(service.update(uuid, request).toResponse(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteByUuid(@PathVariable UUID uuid) {
        service.deleteByUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
