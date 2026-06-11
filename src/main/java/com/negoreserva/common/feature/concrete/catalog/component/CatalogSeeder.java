package com.negoreserva.common.feature.concrete.catalog.component;

import com.negoreserva.common.feature.concrete.catalog.enums.CatalogFaker;
import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.catalog.service.CatalogService;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CatalogSeeder {
    private final CatalogService catalogService;
    private final List<Catalog> items = new ArrayList<>();

    @Setter
    private List<Organization> organizations;

    @Transactional
    public List<Catalog> seed() {
        items.clear();
        for (var data : CatalogFaker.values()) {
            var catalog = data.getCatalog();
            var optional = organizations.stream()
                    .filter(it -> it.getName().equals(catalog.getOrganization().getName()))
                    .findFirst();

            if (optional.isPresent()) {
                catalog.setOrganization(optional.get());
                items.add(catalogService.findOrCreate(catalog));
            }
        }
        return items;
    }
}
