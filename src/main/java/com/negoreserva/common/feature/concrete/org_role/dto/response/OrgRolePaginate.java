package com.negoreserva.common.feature.concrete.org_role.dto.response;

import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import org.springframework.data.domain.Page;

import java.util.List;

public record OrgRolePaginate(
        List<OrgRoleResponse> content,
        boolean empty,
        boolean first,
        boolean last,
        int number,
        int numberOfElements,
        int size,
        long totalElements,
        int totalPages
) {
    public static OrgRolePaginate of(Page<OrgRole> page) {
        return new OrgRolePaginate(
                page.getContent().stream().map(OrgRole::toResponse).toList(),
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
