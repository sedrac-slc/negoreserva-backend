package com.negoreserva.common.feature.concrete.payment.dto.response;

import com.negoreserva.common.feature.core.dto.response.PageResponse;
import com.negoreserva.common.feature.concrete.payment.model.Payment;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
public class PaymentPaginate extends PageResponse<PaymentResponse> {

    public PaymentPaginate(
            List<PaymentResponse> content,
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

    public static PaymentPaginate of(Page<Payment> page) {
        return new PaymentPaginate(
                page.getContent().stream().map(PaymentResponse::toResponse).toList(),
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
