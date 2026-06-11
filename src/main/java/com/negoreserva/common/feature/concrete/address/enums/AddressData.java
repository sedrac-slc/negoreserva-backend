package com.negoreserva.common.feature.concrete.address.enums;

import com.negoreserva.common.feature.concrete.address.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

@Getter
@AllArgsConstructor
public enum AddressData {
    NEW_YORK(
            Address.builder()
                    .country("United States")
                    .state("New York")
                    .city("New York")
                    .neighborhood("Manhattan")
                    .street("123 Main Street")
                    .number("10001")
                    .zipCode("10001")
                    .build()
    ),
    SAN_FRANCISCO(
            Address.builder()
                    .country("United States")
                    .state("California")
                    .city("San Francisco")
                    .neighborhood("SoMa")
                    .street("456 Tech Avenue")
                    .number("94102")
                    .zipCode("94102")
                    .build()
    ),
    CHICAGO(
            Address.builder()
                    .country("United States")
                    .state("Illinois")
                    .city("Chicago")
                    .neighborhood("Loop")
                    .street("789 Business Blvd")
                    .number("60601")
                    .zipCode("60601")
                    .build()
    );

    private final Address address;

    public static List<Address> listAddresses() {
        return Arrays.stream(AddressData.values())
                .map(AddressData::getAddress)
                .toList();
    }

    public static Address random() {
        var addresses = listAddresses();
        var random = RandomGenerator.getDefault();
        var index = random.nextInt(addresses.size());
        return addresses.get(index);
    }
}
