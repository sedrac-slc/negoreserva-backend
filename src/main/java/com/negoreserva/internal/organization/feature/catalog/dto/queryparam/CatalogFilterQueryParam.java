package com.negoreserva.internal.organization.feature.catalog.dto.queryparam;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogFilterQueryParam {
    private String field = CatalogFilterQueryParamType.ALL.getValue();
    private int pageNumber = 0;
    private int pageSize = 10;
    private String search;

    public CatalogFilterQueryParamType getField() {
        return CatalogFilterQueryParamType.fromValue(field);
    }
}
