package com.negoreserva.common.feature.core.repository;

import com.negoreserva.common.feature.core.model.ConcreteModel;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface ConcreteRepository<T extends ConcreteModel> extends CommonRepository<T> {
    Optional<T> findByUuid(UUID uuid);
}