package com.negoreserva.common.feature.core.dto.request;

public record PaginateRequest (
        int pageNumber,
        int pageSize
) {
    public PaginateRequest() {
        this(0, 20);
    }
}
