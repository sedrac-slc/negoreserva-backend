package com.negoreserva.common.feature.pivot.organization_category.component;

import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.pivot.organization_category.enums.OrganizationCategoryData;
import com.negoreserva.common.feature.pivot.organization_category.model.OrganizationCategory;
import com.negoreserva.common.feature.pivot.organization_category.service.OrganizationCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class OrganizationCategorySeeder {
    private final OrganizationCategoryService organizationCategoryService;
    private final List<OrganizationCategory> items = new ArrayList<>();

    @Setter
    private List<Organization> organizations;

    @Setter
    private List<Category> categories;

    @Transactional
    public void seed() {
        for (var data : OrganizationCategoryData.values()) {
            var category = categories.stream()
                    .filter(it -> it.getName().equals(data.getCategory().getName()))
                    .findFirst()
                    .orElse(null);

            var organization = organizations.stream()
                    .filter(it -> it.getName().equals(data.getOrganization().getName()))
                    .findFirst()
                    .orElse(null);

            if (category == null || organization == null) continue;

            var item = new OrganizationCategory();

            item.setCategory(category);
            item.setOrganization(organization);

            items.add(organizationCategoryService.findOrCreate(item));
        }
    }

}
