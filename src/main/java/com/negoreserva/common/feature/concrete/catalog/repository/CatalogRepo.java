package com.negoreserva.common.feature.concrete.catalog.repository;

import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatalogRepo extends ConcreteRepository<Catalog> {
    Optional<Catalog> findByName(String name);
    Optional<Catalog> findBySlug(String slug);
    Optional<Catalog> findByUuid(UUID uuid);
    Page<Catalog> findAllByOrganization(Organization organization, Specification<Catalog> spec, Pageable pageable);
    Page<Catalog> findAllByOrganization(Organization organization, Pageable pageable);
}
