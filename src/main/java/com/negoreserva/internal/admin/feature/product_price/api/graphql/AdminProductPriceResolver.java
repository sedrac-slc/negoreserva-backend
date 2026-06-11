package com.negoreserva.internal.admin.feature.product_price.api.graphql;

import com.negoreserva.common.feature.concrete.product_price.dto.request.ProductPriceRequest;
import com.negoreserva.common.feature.concrete.product_price.dto.response.ProductPricePaginate;
import com.negoreserva.common.feature.concrete.product_price.dto.response.ProductPriceResponse;
import com.negoreserva.common.feature.concrete.product_price.service.ProductPriceService;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class AdminProductPriceResolver {
    private final ProductPriceService service;

    public AdminProductPriceResolver(ProductPriceService service) {
        this.service = service;
    }

    @QueryMapping
    public ProductPriceResponse adminFindByUuidProductPrice(@Argument UUID uuid) {
        return service.findByUuid(uuid).toResponse();
    }

    @QueryMapping
    public ProductPricePaginate adminPaginateProductPrice(@Argument PaginateRequest paginateRequest) {
        return service.paginate(paginateRequest);
    }

    @MutationMapping
    public ProductPriceResponse adminSaveProductPrice(@Argument @Valid ProductPriceRequest productPriceRequest) {
        return service.save(productPriceRequest.toModel(), productPriceRequest.productUuid()).toResponse();
    }

    @MutationMapping
    public ProductPriceResponse adminUpdateProductPrice(@Argument UUID uuid, @Argument @Valid ProductPriceRequest productPriceRequest) {
        return service.update(uuid, productPriceRequest.toModel(), productPriceRequest.productUuid()).toResponse();
    }

    @MutationMapping
    public boolean adminDeleteByUuidProductPrice(@Argument UUID uuid) {
        service.deleteByUuid(uuid);
        return true;
    }
}
