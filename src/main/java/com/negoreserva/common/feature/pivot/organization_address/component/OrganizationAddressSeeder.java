package com.negoreserva.common.feature.pivot.organization_address.component;

import com.negoreserva.common.feature.concrete.address.model.Address;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.pivot.organization_address.enums.OrganizationAddressData;
import com.negoreserva.common.feature.pivot.organization_address.model.OrganizationAddress;
import com.negoreserva.common.feature.pivot.organization_address.service.OrganizationAddressService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrganizationAddressSeeder {
    private final OrganizationAddressService organizationAddressService;
    private final List<OrganizationAddress> items = new ArrayList<>();

    @Setter
    private List<Organization> organizations;

    @Setter
    private List<Address> addresses;

    @Transactional
    public void seed() {
        for (var data : OrganizationAddressData.values()) {
            var address = addresses.stream()
                    .filter(it -> it.getZipCode().equals(data.getAddress().getZipCode()))
                    .findFirst()
                    .orElse(null);

            var organization = organizations.stream()
                    .filter(it -> it.getName().equals(data.getOrganization().getName()))
                    .findFirst()
                    .orElse(null);

            if (address == null || organization == null) continue;

            var item = new OrganizationAddress();
            item.setAddress(address);
            item.setOrganization(organization);

            items.add(organizationAddressService.findOrCreate(item));
        }
    }
}
