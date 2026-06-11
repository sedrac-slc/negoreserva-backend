package com.negoreserva.common.feature.concrete.product.dto.queryparam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchFilterParam {
    private String q;
    private BigDecimal priceMin;
    private BigDecimal priceMax;
    private List<UUID> organizationUuids;
}
