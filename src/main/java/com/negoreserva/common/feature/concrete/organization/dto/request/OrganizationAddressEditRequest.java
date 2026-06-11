package com.negoreserva.common.feature.concrete.organization.dto.request;

import jakarta.validation.constraints.Size;

public record OrganizationAddressEditRequest(
        @Size(max = 255)
        String address
) {
}
