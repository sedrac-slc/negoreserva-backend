package com.negoreserva.internal.organization.feature.payment.query;

import com.negoreserva.common.feature.concrete.payment.model.Payment;
import com.negoreserva.internal.organization.feature.payment.dto.queryparam.PaymentFilterQueryParam;
import com.negoreserva.internal.organization.feature.payment.enums.PaymentFilterQueryParamType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentFilterSpecification implements Specification<Payment> {

    private final PaymentFilterQueryParam filter;

    public PaymentFilterSpecification(PaymentFilterQueryParam filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Payment> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.isNull(root.get("deletedBy")));
        predicates.add(cb.isNull(root.get("deletedAt")));

        Optional.ofNullable(filter.getSearch()).filter((it -> !it.isBlank())).ifPresent((it) -> {
            String search = it.toLowerCase();
            var fieldEnum = filter.getFieldAsEnum();
            if (fieldEnum == PaymentFilterQueryParamType.ALL) {
                predicates.add(cb.or(
                        cb.like(cb.lower(root.get("status").as(String.class)), ("%" + search + "%")),
                        cb.like(cb.lower(root.get("type").as(String.class)), ("%" + search + "%"))
                ));
            } else if (fieldEnum == PaymentFilterQueryParamType.STATUS) {
                predicates.add(cb.like(cb.lower(root.get("status").as(String.class)), ("%" + search + "%")));
            } else if (fieldEnum == PaymentFilterQueryParamType.TYPE) {
                predicates.add(cb.like(cb.lower(root.get("type").as(String.class)), ("%" + search + "%")));
            }
        });

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
