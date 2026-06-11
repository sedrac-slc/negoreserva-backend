package com.negoreserva.internal.admin.feature.user.query;

import com.negoreserva.common.feature.concrete.user.dto.queryparam.UserFilterQueryParam;
import com.negoreserva.internal.admin.feature.user.enums.UserFilterQueryParamType;
import com.negoreserva.common.feature.concrete.user.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserFilterSpecification implements Specification<User> {

    private final UserFilterQueryParam filter;

    public UserFilterSpecification(UserFilterQueryParam filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<User> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.isNull(root.get("deletedBy")));
        predicates.add(cb.isNull(root.get("deletedAt")));

        Optional.ofNullable(filter.getSearch()).filter((it -> !it.isBlank())).ifPresent((it) -> {
            String search = it.toLowerCase();
            if (filter.getField() == UserFilterQueryParamType.ALL) {
                predicates.add(cb.or(
                    cb.like(cb.lower(root.get("name")), ("%" + search + "%")),
                    cb.like(cb.lower(root.get("email")), ("%" + search + "%")),
                    cb.like(cb.lower(root.get("phone")), ("%" + search + "%"))
                ));
            } else if (filter.getField() == UserFilterQueryParamType.NAME) {
                predicates.add(cb.like(cb.lower(root.get("name")), ("%" + search + "%")));
            } else if (filter.getField() == UserFilterQueryParamType.EMAIL) {
                predicates.add(cb.like(cb.lower(root.get("email")), ("%" + search + "%")));
            } else if (filter.getField() == UserFilterQueryParamType.PHONE) {
                predicates.add(cb.like(cb.lower(root.get("phone")), ("%" + search + "%")));
            }
        });

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}