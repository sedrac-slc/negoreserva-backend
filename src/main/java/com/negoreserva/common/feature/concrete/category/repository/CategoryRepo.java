package com.negoreserva.common.feature.concrete.category.repository;

import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepo extends ConcreteRepository<Category> {
    List<Category> findByUuidIn(List<UUID> uuids);
    Optional<Category> findByName(String name);
}