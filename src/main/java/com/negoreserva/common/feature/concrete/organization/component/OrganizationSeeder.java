package com.negoreserva.common.feature.concrete.organization.component;

import com.negoreserva.common.feature.concrete.organization.enums.OrganizationFaker;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.organization.service.OrganizationService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationSeeder {
    private final OrganizationService organizationService;

    public OrganizationSeeder(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Transactional
    public List<Organization> seed() {
        List<Organization> items = new ArrayList<>();
        for (OrganizationFaker organization : OrganizationFaker.values()) {
            items.add(organizationService.findOrCreate(organization.getOrganization()));
        }
        return items;
    }
}