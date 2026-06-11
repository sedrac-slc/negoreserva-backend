package com.negoreserva.common.feature.pivot.catalog_products.component;

import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.pivot.catalog_products.model.CatalogProducts;
import com.negoreserva.common.feature.pivot.catalog_products.service.CatalogProductsService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CatalogProductsSeeder {
    private final CatalogProductsService catalogProductsService;
    private final List<CatalogProducts> items = new ArrayList<>();

    @Setter
    private List<Catalog> catalogs;

    @Setter
    private List<Product> products;

    @Transactional
    public void seed() {
        // For each catalog, associate the first 3 products from the same organization
        for (var catalog : catalogs) {
            var orgProducts = products.stream()
                    .filter(p -> p.getOrganization().getId() == catalog.getOrganization().getId())
                    .limit(3)
                    .toList();

            for (int i = 0; i < orgProducts.size(); i++) {
                var cp = CatalogProducts.builder()
                        .catalog(catalog)
                        .product(orgProducts.get(i))
                        .order(i + 1)
                        .build();
                items.add(catalogProductsService.findOrCreate(cp));
            }
        }
    }
}
