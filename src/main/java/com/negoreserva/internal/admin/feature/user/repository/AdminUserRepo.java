package com.negoreserva.internal.admin.feature.user.repository;

import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminUserRepo extends ConcreteRepository<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
}