package com.negoreserva.common.feature.concrete.product_file.dto.response;

import com.negoreserva.common.feature.concrete.product.dto.response.ProductResponse;
import com.negoreserva.common.feature.concrete.product_file.enums.ProductFileType;

import java.util.UUID;

public record ProductFileResponse(
        UUID uuid,
        UUID productUuid,
        String title,
        String description,
        String url,
        ProductFileType type,
        ProductResponse product,
        boolean isPrimary
) { }