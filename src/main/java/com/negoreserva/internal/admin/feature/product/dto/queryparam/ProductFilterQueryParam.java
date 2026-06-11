package com.negoreserva.internal.admin.feature.product.dto.queryparam;

import com.negoreserva.internal.admin.feature.product.enums.ProductFilterQueryParamType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductFilterQueryParam {
    private String field = ProductFilterQueryParamType.ALL.getValue();
    private int pageNumber = 0;
    private int pageSize = 10;
    private String search;

    public ProductFilterQueryParamType getField() {
        return ProductFilterQueryParamType.fromValue(field);
    }
}