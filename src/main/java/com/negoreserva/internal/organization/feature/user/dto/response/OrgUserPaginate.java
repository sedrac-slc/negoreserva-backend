package com.negoreserva.internal.organization.feature.user.dto.response;

import com.negoreserva.common.feature.concrete.user.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public record OrgUserPaginate(
        List<OrgUserResponse> content,
        boolean empty,
        boolean first,
        boolean last,
        int number,
        int numberOfElements,
        int size,
        long totalElements,
        int totalPages
) {
    public static OrgUserPaginate of(Page<User> page) {
        return new OrgUserPaginate(
                page.getContent().stream().map(OrgUserResponse::of).toList(),
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
