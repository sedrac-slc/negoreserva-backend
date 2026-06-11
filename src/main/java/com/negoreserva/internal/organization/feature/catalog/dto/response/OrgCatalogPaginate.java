package com.negoreserva.internal.organization.feature.catalog.dto.response;

import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import org.springframework.data.domain.Page;

import java.util.List;

public record OrgCatalogPaginate(
    List<OrgCatalogResponse> content,
    boolean empty,
    boolean first,
    boolean last,
    int number,
    int numberOfElements,
    int size,
    long totalElements,
    int totalPages
) {
    public static OrgCatalogPaginate of(Page<Catalog> page) {
        var content = page.getContent().stream().map(OrgCatalogResponse::toResponse).toList();
        return new OrgCatalogPaginate(
            content, page.isEmpty(), page.isFirst(), page.isLast(),
            page.getNumber(), page.getNumberOfElements(), page.getSize(),
            page.getTotalElements(), page.getTotalPages()
        );
    }
}
