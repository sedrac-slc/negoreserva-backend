package com.negoreserva.external.feature.organization.api.rest;

import com.negoreserva.external.feature.organization.dto.response.ExtGetOrganizationPaginate;
import com.negoreserva.external.feature.organization.dto.response.OrganizationDetailResponse;
import com.negoreserva.external.feature.organization.service.ExOrganizationService;
import com.negoreserva.external.feature.organization.util.OrganizationRouteNamed;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(OrganizationRouteNamed.PATH)
public class OrganizationEndpoint {
    private final ExOrganizationService service;

    @GetMapping
    @Operation(summary = "Get all organizations")
    public ResponseEntity<ExtGetOrganizationPaginate> findAll(@ParameterObject Pageable page) {
        return ResponseEntity.ok(service.paginate(page));
    }

    @GetMapping(OrganizationRouteNamed.FIND_DETAIL)
    @Operation(summary = "Get organization by id")
    public ResponseEntity<OrganizationDetailResponse> findDetail(@PathVariable String uuidOrSlug) {
        var organization = service.findByUuidOrSlug(uuidOrSlug);
        return ResponseEntity.ok(OrganizationDetailResponse.of(organization));
    }

    @PostMapping(OrganizationRouteNamed.FILTER)
    @Operation(summary = "Get organizations by categories")
    public ResponseEntity<ExtGetOrganizationPaginate> findAllByCategories(
            @RequestParam List<UUID> categoryUuids,
            @ParameterObject Pageable page
    ) {
        return ResponseEntity.ok(service.paginate(categoryUuids, page));
    }
}
