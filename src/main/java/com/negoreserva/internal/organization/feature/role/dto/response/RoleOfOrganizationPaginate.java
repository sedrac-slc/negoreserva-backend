package com.negoreserva.internal.organization.feature.role.dto.response;

import com.negoreserva.common.feature.core.dto.response.PageResponse;
import com.negoreserva.internal.organization.feature.role.model.RoleOfOrganization;
import org.springframework.data.domain.Page;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class RoleOfOrganizationPaginate extends PageResponse<RoleOfOrganizationResponse> {

    public RoleOfOrganizationPaginate(
            List<RoleOfOrganizationResponse> content,
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

    public static RoleOfOrganizationPaginate of(Page<RoleOfOrganization> page) {
        return new RoleOfOrganizationPaginate(
                page.getContent().stream().map(RoleOfOrganization::toResponse).toList(),
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