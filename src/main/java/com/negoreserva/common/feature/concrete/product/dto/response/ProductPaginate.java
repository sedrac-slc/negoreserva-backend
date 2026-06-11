package com.negoreserva.common.feature.concrete.product.dto.response;

import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.core.dto.response.PageResponse;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
public class ProductPaginate extends PageResponse<ProductResponse> {

    public ProductPaginate(
            List<ProductResponse> content,
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

    public static ProductPaginate of(Page<Product> page) {
        return new ProductPaginate(
                page.getContent().stream().map(Product::toResponse).toList(),
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