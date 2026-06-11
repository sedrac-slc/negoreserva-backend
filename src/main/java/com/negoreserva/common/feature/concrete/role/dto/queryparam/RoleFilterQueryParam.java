package com.negoreserva.common.feature.concrete.role.dto.queryparam;

import com.negoreserva.common.feature.concrete.role.enums.RoleFilterQueryParamType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleFilterQueryParam {
    private String field;
    private String search;
    private Integer pageSize;
    private Integer pageNumber;

    public RoleFilterQueryParamType getField() {
        try {
            return RoleFilterQueryParamType.valueOf(field);
        } catch (Exception e) {
            return RoleFilterQueryParamType.ALL;
        }
    }
}
