package com.negoreserva.internal.admin.feature.organization.dto.queryparam;

import com.negoreserva.internal.admin.feature.organization.enums.OrganizationFilterQueryParamType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationFilterQueryParam {
    private String field = OrganizationFilterQueryParamType.ALL.getValue();
    private int pageNumber = 0;
    private int pageSize = 10;
    private String search;

    public OrganizationFilterQueryParamType getField() {
        return OrganizationFilterQueryParamType.fromValue(field);
    }
}