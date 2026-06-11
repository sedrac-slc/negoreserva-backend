package com.negoreserva.common.feature.core.service;

import com.negoreserva.common.contract.UniqueFieldSanitizer;
import com.negoreserva.common.exception.NotFoundException;
import com.negoreserva.common.feature.core.model.ConcreteModel;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public abstract class ConcreteService<T extends ConcreteModel> extends CommonService<T> {
    
    private final ConcreteRepository<T> repository;

    public ConcreteService(ConcreteRepository<T> repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Page<T> findAll(Pageable pageable) { return repository.findAll(pageable); }

    @Override
    public List<T> findAll() { return repository.findAll(); }

    @Override
    @Transactional
    public T save(T data) {
        return super.save(data);
    }

    @Override
    public T update(UUID uuid, T data) {
        var item = repository.findByUuid(uuid).orElseThrow(NotFoundException::new);
        data.setId(item.getId());
        return save(data);
    }

    @Override
    public T update(long id, T data) {
        var item = repository.findById(id).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(data, item, "id", "uuid");
        return save(item);
    }

    @Override
    public boolean deleteByUuid(UUID uuid) {
        var item = repository.findByUuid(uuid).orElseThrow(NotFoundException::new);
        if(item instanceof UniqueFieldSanitizer u) u.sanitizeUniqueFields();
        item.setDeletedAt(Instant.now());
        super.save(item);
        return true;
    }

}
