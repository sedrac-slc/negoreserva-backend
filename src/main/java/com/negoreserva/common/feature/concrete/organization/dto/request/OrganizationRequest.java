package com.negoreserva.common.feature.concrete.organization.dto.request;

import com.negoreserva.common.feature.concrete.organization.model.Organization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record OrganizationRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name too long")
        String name,

        @NotBlank(message = "Email is required")
        @Size(max = 100, message = "Email too long")
        String email,

        @Size(max = 255, message = "Description too long")
        String description,

        @NotBlank(message = "Phone is required")
        @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Phone invalid")
        @Size(max = 15)
        String phone,

        @Size(max = 255, message = "Address too long")
        String address,

        @Size(max = 5, message = "Rating too long")
        @PositiveOrZero
        Integer rating
) {

    public Organization toModel() {
        return Organization.builder()
                .name(name)
                .email(email)
                .description(description)
                .phone(phone)
                .address(address)
                .rating(rating)
                .build();
    }
}