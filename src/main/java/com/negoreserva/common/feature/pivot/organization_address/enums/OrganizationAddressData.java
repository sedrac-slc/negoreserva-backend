package com.negoreserva.common.feature.pivot.organization_address.enums;

import com.negoreserva.common.feature.concrete.address.enums.AddressData;
import com.negoreserva.common.feature.concrete.address.model.Address;
import com.negoreserva.common.feature.concrete.organization.enums.OrganizationFaker;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrganizationAddressData {
    GLOBAL_NEW_YORK(OrganizationFaker.GLOBAL.getOrganization(), AddressData.NEW_YORK.getAddress()),
    TECHCORP_SAN_FRANCISCO(OrganizationFaker.TECHCORP.getOrganization(), AddressData.SAN_FRANCISCO.getAddress()),
    ACME_CHICAGO(OrganizationFaker.ACME.getOrganization(), AddressData.CHICAGO.getAddress());

    private final Organization organization;
    private final Address address;
}
