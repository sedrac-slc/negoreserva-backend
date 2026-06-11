package com.negoreserva.internal.organization.feature.role.repository;

import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgCategoryRepo extends ConcreteRepository<Category> {
    Optional<Category> findByName(String name);
}