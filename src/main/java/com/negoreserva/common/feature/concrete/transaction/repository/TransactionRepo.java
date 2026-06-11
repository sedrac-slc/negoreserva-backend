package com.negoreserva.common.feature.concrete.transaction.repository;

import com.negoreserva.common.feature.concrete.transaction.model.Transaction;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends ConcreteRepository<Transaction> {
}
