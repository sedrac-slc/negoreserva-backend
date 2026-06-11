package com.negoreserva.common.feature.concrete.address.dto.request;

import com.negoreserva.common.feature.concrete.address.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressRequest(
        @NotBlank
        @Size(max = 100)
        String country,
        @NotBlank
        @Size(max = 100)
        String state,
        @NotBlank
        @Size(max = 100)
        String city,
        @Size(max = 100)
        String neighborhood,
        @NotBlank
        @Size(max = 255)
        String street,
        @Size(max = 20)
        String number,
        @Size(max = 20)
        String zipCode,
        @Size(max = 255)
        String complement,
        Double latitude,
        Double longitude
) {
    public Address toModel() {
        return Address.builder()
                .country(country)
                .state(state)
                .city(city)
                .neighborhood(neighborhood)
                .street(street)
                .number(number)
                .zipCode(zipCode)
                .complement(complement)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
