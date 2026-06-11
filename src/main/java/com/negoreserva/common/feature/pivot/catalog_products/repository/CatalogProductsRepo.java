package com.negoreserva.common.feature.pivot.catalog_products.repository;

import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.pivot.catalog_products.model.CatalogProducts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatalogProductsRepo extends JpaRepository<CatalogProducts, Long> {
    boolean existsByCatalogAndProduct(Catalog catalog, Product product);
    Optional<CatalogProducts> findByCatalogAndProduct(Catalog catalog, Product product);
    Page<CatalogProducts> findAllByCatalog(Catalog catalog, Pageable pageable);
    List<CatalogProducts> findAllByCatalog(Catalog catalog);
    List<CatalogProducts> findAllByCatalogOrderByOrderAsc(Catalog catalog);

    @Modifying
    @Query("DELETE FROM CatalogProducts cp WHERE cp.catalog = :catalog AND cp.product.uuid IN :productUuids")
    void deleteByCatalogAndProductUuidIn(@Param("catalog") Catalog catalog, @Param("productUuids") List<UUID> productUuids);
}
