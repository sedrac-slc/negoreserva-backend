package com.negoreserva.internal.organization.feature.payment.dto.queryparam;

import com.negoreserva.internal.organization.feature.payment.enums.PaymentFilterQueryParamType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentFilterQueryParam {
    private String field = PaymentFilterQueryParamType.ALL.getValue();
    private int pageNumber = 0;
    private int pageSize = 10;
    private String search;

    public PaymentFilterQueryParamType getFieldAsEnum() {
        return PaymentFilterQueryParamType.fromValue(field);
    }
}
