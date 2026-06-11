package com.negoreserva.common.feature.concrete.plan.repository;

import com.negoreserva.common.feature.concrete.plan.model.Plan;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanRepo extends ConcreteRepository<Plan> {
    Optional<Plan> findByName(String name);
}
