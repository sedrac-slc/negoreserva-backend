package com.negoreserva.external.feature.organization.dto.response;

import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.external.feature.organization.mapper.GetOrganizationMapper;
import com.negoreserva.common.feature.core.dto.response.PageResponse;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
public class ExtGetOrganizationPaginate extends PageResponse<GetOrganizationResponse> {

    public ExtGetOrganizationPaginate(
            List<GetOrganizationResponse> content,
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

    public static ExtGetOrganizationPaginate of(Page<Organization> page) {
        return new ExtGetOrganizationPaginate(
                page.getContent()
                        .stream()
                        .map(GetOrganizationMapper::new)
                        .map(GetOrganizationMapper::toResponse)
                        .toList(),
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