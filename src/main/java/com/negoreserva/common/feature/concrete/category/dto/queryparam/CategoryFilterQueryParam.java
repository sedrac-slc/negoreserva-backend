package com.negoreserva.common.feature.concrete.category.dto.queryparam;

import com.negoreserva.common.feature.concrete.category.enums.CategoryFilterQueryParamType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryFilterQueryParam {
    private String field = CategoryFilterQueryParamType.ALL.getValue();
    private int pageNumber = 0;
    private int pageSize = 10;
    private String search;

    public CategoryFilterQueryParamType getField() {
        return CategoryFilterQueryParamType.fromValue(field);
    }
}