package com.negoreserva.common.feature.concrete.transaction.dto.response;

import com.negoreserva.common.feature.concrete.transaction.model.Transaction;
import com.negoreserva.common.feature.core.dto.response.PageResponse;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
public class TransactionPaginate extends PageResponse<TransactionResponse> {
    public TransactionPaginate(
            List<TransactionResponse> content, boolean empty, boolean first, boolean last,
            int number, int numberOfElements, int size, long totalElements, int totalPages
    ) {
        super(content, empty, first, last, number, numberOfElements, size, totalElements, totalPages);
    }

    public static TransactionPaginate of(Page<Transaction> page) {
        return new TransactionPaginate(
                page.getContent().stream().map(Transaction::toResponse).toList(),
                page.isEmpty(), page.isFirst(), page.isLast(),
                page.getNumber(), page.getNumberOfElements(),
                page.getSize(), page.getTotalElements(), page.getTotalPages()
        );
    }
}
