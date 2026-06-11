package com.negoreserva.internal.admin.feature.product_price.api.rest;

import com.negoreserva.common.feature.concrete.product_price.dto.request.ProductPriceRequest;
import com.negoreserva.common.feature.concrete.product_price.dto.response.ProductPricePaginate;
import com.negoreserva.common.feature.concrete.product_price.dto.response.ProductPriceResponse;
import com.negoreserva.common.feature.concrete.product_price.service.ProductPriceService;
import com.negoreserva.internal.admin.feature.product_price.util.ProductPriceRouteNamed;
import com.negoreserva.common.feature.concrete.product_price.model.ProductPrice;
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
@RequestMapping(ProductPriceRouteNamed.PATH)
@Tag(name = "Admin - ProductPrice", description = "Endpoints for price product management")
public class AdminProductPriceController {

    private final ProductPriceService service;

    @GetMapping
    @Operation(summary = "Get all product prices")
    public ResponseEntity<ProductPricePaginate> findAll(@ParameterObject Pageable page) {
        return ResponseEntity.ok(service.paginate(page));
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Get product price by uuid")
    public ResponseEntity<ProductPriceResponse> findByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid).toResponse());
    }

    @PostMapping
    @Operation(summary = "Create product price")
    public ResponseEntity<ProductPriceResponse> save(@RequestBody @Valid ProductPriceRequest productPriceDto) {
        ProductPrice productPrice = service.save(productPriceDto.toModel(), productPriceDto.productUuid());
        return new ResponseEntity<>(productPrice.toResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @Operation(summary = "Update product price")
    public ResponseEntity<ProductPriceResponse> update(@PathVariable UUID uuid, @RequestBody @Valid ProductPriceRequest productPriceDto) {
        ProductPrice productPrice = service.update(uuid, productPriceDto.toModel(), productPriceDto.productUuid());
        return new ResponseEntity<>(productPrice.toResponse(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Delete product price by uuid")
    public ResponseEntity<Void> deleteByUuid(@PathVariable UUID uuid) {
        service.deleteByUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}
