package com.negoreserva.common.feature.concrete.address.dto.queryparam;

import com.negoreserva.common.feature.concrete.address.enums.AddressFilterQueryParamType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressFilterQueryParam {
    private String field = AddressFilterQueryParamType.ALL.getValue();
    private int pageNumber = 0;
    private int pageSize = 10;
    private String search;

    public AddressFilterQueryParamType getField() {
        return AddressFilterQueryParamType.fromValue(field);
    }
}
