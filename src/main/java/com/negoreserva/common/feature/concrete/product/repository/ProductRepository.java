package com.negoreserva.common.feature.concrete.product.repository;

import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.core.repository.SearchableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends SearchableRepository<Product> {
    Page<Product> findAllByOrganization(Organization organization, Specification<Product> spec, Pageable  pageable);
    Page<Product> findAllByOrganization(Organization organization, Pageable pageable);
    Optional<Product> findByName(String name);
    Optional<Product> findBySlug(String slug);
    Optional<Product> findByUuid(UUID uuid);

    @Query("SELECT p FROM Product p WHERE p.organization = :organization AND p.uuid NOT IN " +
           "(SELECT cp.product.uuid FROM CatalogProducts cp WHERE cp.catalog.uuid = :catalogUuid)")
    Page<Product> findAllByOrganizationNotInCatalog(@Param("organization") Organization organization, @Param("catalogUuid") UUID catalogUuid, Pageable pageable);
}