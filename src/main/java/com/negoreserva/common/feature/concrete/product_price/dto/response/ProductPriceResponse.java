package com.negoreserva.common.feature.concrete.product_price.dto.response;

import com.negoreserva.common.feature.concrete.product.dto.response.ProductResponse;
import com.negoreserva.common.feature.concrete.product_price.enums.ProductPriceType;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductPriceResponse(
        UUID uuid,
        UUID productUuid,
        ProductPriceType type,
        BigDecimal value,
        Integer order,
        Boolean isPrimary,
        Integer unit,
        ProductResponse product
) {
}
