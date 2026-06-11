package com.negoreserva.common.feature.pivot.catalog_products.service;

import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.pivot.catalog_products.model.CatalogProducts;
import com.negoreserva.common.feature.pivot.catalog_products.repository.CatalogProductsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatalogProductsService {
    private final CatalogProductsRepo catalogProductsRepo;

    public boolean existsByCatalogAndProduct(Catalog catalog, Product product) {
        return catalogProductsRepo.existsByCatalogAndProduct(catalog, product);
    }

    public CatalogProducts save(CatalogProducts catalogProducts) {
        return catalogProductsRepo.save(catalogProducts);
    }

    public CatalogProducts findOrCreate(CatalogProducts catalogProducts) {
        return catalogProductsRepo.findByCatalogAndProduct(
            catalogProducts.getCatalog(),
            catalogProducts.getProduct()
        ).orElseGet(() -> save(catalogProducts));
    }

    public Page<CatalogProducts> findAllByCatalog(Catalog catalog, Pageable pageable) {
        return catalogProductsRepo.findAllByCatalog(catalog, pageable);
    }

    public List<CatalogProducts> findAllByCatalog(Catalog catalog) {
        return catalogProductsRepo.findAllByCatalog(catalog);
    }

    public List<CatalogProducts> findAllByCatalogOrderByOrderAsc(Catalog catalog) {
        return catalogProductsRepo.findAllByCatalogOrderByOrderAsc(catalog);
    }

    @Transactional
    public void addProducts(Catalog catalog, List<Product> products) {
        for (var product : products) {
            if (!catalogProductsRepo.existsByCatalogAndProduct(catalog, product)) {
                var cp = CatalogProducts.builder()
                    .catalog(catalog)
                    .product(product)
                    .build();
                catalogProductsRepo.save(cp);
            }
        }
    }

    @Transactional
    public void addProductsWithOrder(Catalog catalog, List<Product> products, java.util.Map<UUID, Integer> productOrders) {
        for (var product : products) {
            if (!catalogProductsRepo.existsByCatalogAndProduct(catalog, product)) {
                var order = productOrders.getOrDefault(product.getUuid(), 1);
                var cp = CatalogProducts.builder()
                    .catalog(catalog)
                    .product(product)
                    .order(order)
                    .build();
                catalogProductsRepo.save(cp);
            }
        }
    }

    @Transactional
    public void removeProducts(Catalog catalog, List<UUID> productUuids) {
        catalogProductsRepo.deleteByCatalogAndProductUuidIn(catalog, productUuids);
    }
}
