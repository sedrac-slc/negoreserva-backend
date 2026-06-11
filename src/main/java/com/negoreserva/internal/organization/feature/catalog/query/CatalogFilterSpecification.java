package com.negoreserva.internal.organization.feature.catalog.query;

import com.negoreserva.internal.organization.feature.catalog.dto.queryparam.CatalogFilterQueryParam;
import com.negoreserva.internal.organization.feature.catalog.dto.queryparam.CatalogFilterQueryParamType;
import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogFilterSpecification implements Specification<Catalog> {

    private final CatalogFilterQueryParam filter;

    public CatalogFilterSpecification(CatalogFilterQueryParam filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Catalog> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.isNull(root.get("deletedBy")));
        predicates.add(cb.isNull(root.get("deletedAt")));

        Optional.ofNullable(filter.getSearch()).filter((it -> !it.isBlank())).ifPresent((it) -> {
            String search = it.toLowerCase();
            if (filter.getField() == CatalogFilterQueryParamType.ALL) {
                predicates.add(cb.or(
                    cb.like(cb.lower(root.get("name")), ("%" + search + "%")),
                    cb.like(cb.lower(root.get("description")), ("%" + search + "%"))
                ));
            } else if (filter.getField() == CatalogFilterQueryParamType.NAME) {
                predicates.add(cb.like(cb.lower(root.get("name")), ("%" + search + "%")));
            } else if (filter.getField() == CatalogFilterQueryParamType.DESCRIPTION) {
                predicates.add(cb.like(cb.lower(root.get("description")), ("%" + search + "%")));
            }
        });

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
