package com.negoreserva.common.feature.concrete.org_permission.dto.response;

import com.negoreserva.common.feature.concrete.org_permission.model.OrgPermission;
import org.springframework.data.domain.Page;

import java.util.List;

public record OrgPermissionPaginate(
        List<OrgPermissionResponse> content,
        boolean empty,
        boolean first,
        boolean last,
        int number,
        int numberOfElements,
        int size,
        long totalElements,
        int totalPages
) {
    public static OrgPermissionPaginate of(Page<OrgPermission> page) {
        return new OrgPermissionPaginate(
                page.getContent().stream().map(OrgPermission::toResponse).toList(),
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
