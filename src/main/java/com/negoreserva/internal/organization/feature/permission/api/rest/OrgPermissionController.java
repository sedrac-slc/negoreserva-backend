package com.negoreserva.internal.organization.feature.permission.api.rest;

import com.negoreserva.common.feature.concrete.org_permission.dto.request.OrgPermissionRequest;
import com.negoreserva.common.feature.concrete.org_permission.dto.response.OrgPermissionPaginate;
import com.negoreserva.common.feature.concrete.org_permission.dto.response.OrgPermissionResponse;
import com.negoreserva.internal.organization.feature.permission.service.OrgPermissionService;
import com.negoreserva.internal.organization.feature.permission.util.OrgPermissionRouteNamed;
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
@RequestMapping(OrgPermissionRouteNamed.PATH)
public class OrgPermissionController {
    private final OrgPermissionService service;

    @GetMapping
    public ResponseEntity<OrgPermissionPaginate> findAll(@ParameterObject Pageable page) {
        return ResponseEntity.ok(service.paginate(page));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrgPermissionResponse> findByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid).toResponse());
    }

    @PostMapping
    public ResponseEntity<OrgPermissionResponse> save(@RequestBody @Valid OrgPermissionRequest request) {
        return new ResponseEntity<>(service.save(request.toModel()).toResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrgPermissionResponse> update(@PathVariable UUID uuid, @RequestBody @Valid OrgPermissionRequest request) {
        return new ResponseEntity<>(service.update(uuid, request.toModel()).toResponse(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteByUuid(@PathVariable UUID uuid) {
        service.deleteByUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
