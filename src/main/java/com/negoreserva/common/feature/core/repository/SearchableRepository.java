package com.negoreserva.common.feature.core.repository;

import com.negoreserva.common.feature.core.model.ConcreteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface SearchableRepository<T extends ConcreteModel> extends ConcreteRepository<T> {
    @Query("SELECT e FROM #{#entityName} e WHERE e.concat LIKE %:contact%")
    Page<T> findByLikeContact(@Param("contact") String contact, Pageable pageable);
}
