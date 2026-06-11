package com.negoreserva.common.feature.pivot.organization_category.service;

import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.pivot.organization_category.model.OrganizationCategory;
import com.negoreserva.common.feature.pivot.organization_category.repository.OrganizationCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationCategoryService {
    private final OrganizationCategoryRepo organizationCategoryRepo;

    public boolean existsByOrganizationAndCategory(Organization organization, Category category) {
        return organizationCategoryRepo.existsByOrganizationAndCategory(organization, category);
    }

    public OrganizationCategory save(OrganizationCategory organizationCategory) {
        return organizationCategoryRepo.save(organizationCategory);
    }

    public OrganizationCategory findOrCreate(OrganizationCategory organizationCategory) {
        return organizationCategoryRepo.findByOrganizationAndCategory(
                organizationCategory.getOrganization(),
                organizationCategory.getCategory()
        ).orElseGet(() -> save(organizationCategory));
    }
}
