package com.negoreserva.common.feature.concrete.catalog.query;

import com.negoreserva.common.feature.concrete.catalog.dto.queryparam.CatalogSearchFilterParam;
import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.organization.enums.OrganizationStatus;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogSearchSpecification implements Specification<Catalog> {
    private final CatalogSearchFilterParam filter;

    public CatalogSearchSpecification(CatalogSearchFilterParam filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Catalog> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.isNull(root.get("deletedBy")));
        predicates.add(cb.isNull(root.get("deletedAt")));

        Join<Catalog, Organization> orgJoin = root.join("organization");
        predicates.add(cb.equal(orgJoin.get("status"), OrganizationStatus.VISIBLE));

        Optional.ofNullable(filter.getQ()).filter(s -> !s.isBlank()).ifPresent(search ->
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + search.toLowerCase() + "%"))
        );

        Optional.ofNullable(filter.getOrganizationUuids())
                .filter(orgUuids -> !orgUuids.isEmpty())
                .ifPresent(orgUuids -> predicates.add(orgJoin.get("uuid").in(orgUuids)));

        query.distinct(true);
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
