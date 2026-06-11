package com.negoreserva.internal.organization.feature.payment.dto.response;

import com.negoreserva.common.feature.core.dto.response.PageResponse;
import com.negoreserva.common.feature.concrete.payment.model.Payment;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
public class OrgPaymentPaginate extends PageResponse<OrgPaymentResponse> {

    public OrgPaymentPaginate(
            List<OrgPaymentResponse> content,
            boolean empty,
            boolean first,
            boolean last,
            int number,
            int numberOfElements,
            int size,
            long totalElements,
            int totalPages
    ) {
        super(content, empty, first, last, number, numberOfElements, size, totalElements, totalPages);
    }

    public static OrgPaymentPaginate of(Page<Payment> page) {
        return new OrgPaymentPaginate(
                page.getContent().stream().map(OrgPaymentResponse::toResponse).toList(),
                page.isEmpty(),
                page.isFirst(),
                page.isLast(),
                page.getNumber(),
                page.getNumberOfElements(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
