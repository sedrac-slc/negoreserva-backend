package com.negoreserva.common.feature.concrete.payment_file_receipt.repository;

import com.negoreserva.common.feature.concrete.payment_file_receipt.model.PaymentFileReceipt;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentFileReceiptRepo extends ConcreteRepository<PaymentFileReceipt> {
}
