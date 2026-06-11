package com.negoreserva.common.feature.concrete.address.dto.response;

import com.negoreserva.common.feature.concrete.address.model.Address;
import com.negoreserva.common.feature.core.dto.response.PageResponse;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import java.util.List;

@NoArgsConstructor
public class AddressPaginate extends PageResponse<AddressResponse> {
    public AddressPaginate(
            List<AddressResponse> content, boolean empty, boolean first, boolean last,
            int number, int numberOfElements, int size, long totalElements, int totalPages
    ) {
        super(content, empty, first, last, number, numberOfElements, size, totalElements, totalPages);
    }

    public static AddressPaginate of(Page<Address> page) {
        return new AddressPaginate(
                page.getContent().stream().map(Address::toResponse).toList(),
                page.isEmpty(), page.isFirst(), page.isLast(),
                page.getNumber(), page.getNumberOfElements(), page.getSize(),
                page.getTotalElements(), page.getTotalPages()
        );
    }
}
