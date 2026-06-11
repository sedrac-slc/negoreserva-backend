package com.negoreserva.internal.organization.feature.product.dto.response;

import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.core.dto.response.PageResponse;
import org.springframework.data.domain.Page;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class OrgProductPaginate extends PageResponse<OrgProductResponse> {

    public OrgProductPaginate(
            List<OrgProductResponse> content,
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

    public static OrgProductPaginate of(Page<Product> page) {
        return new OrgProductPaginate(
                page.getContent().stream().map(OrgProductResponse::toResponse).toList(),
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