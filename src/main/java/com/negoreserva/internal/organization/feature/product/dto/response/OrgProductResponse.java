package com.negoreserva.internal.organization.feature.product.dto.response;

import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.internal.organization.feature.product_file.dto.response.OrgProductFileResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrgProductResponse(
        UUID uuid,
        String name,
        String slug,
        String description,
        String image,
        List<OrgProductFileResponse> files
) {

    public static OrgProductResponse toResponse(Product product) {
        var files = product.getProductFiles().stream().map(OrgProductFileResponse::toResponse).toList();

        return new OrgProductResponse(
                product.getUuid(),
                product.getName(),
                product.getSlug(),
                product.getDescription(),
                product.getImage(),
                files
        );
    }

}
