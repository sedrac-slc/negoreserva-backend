package com.negoreserva.common.feature.concrete.payment_file_receipt.service;

import com.negoreserva.common.feature.concrete.payment_file_receipt.exception.notfound.PaymentFileReceiptNotFoundException;
import com.negoreserva.common.feature.concrete.payment_file_receipt.model.PaymentFileReceipt;
import com.negoreserva.common.feature.concrete.payment_file_receipt.repository.PaymentFileReceiptRepo;
import com.negoreserva.common.feature.core.service.ConcreteService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentFileReceiptService extends ConcreteService<PaymentFileReceipt> {
    private final PaymentFileReceiptRepo repository;

    public PaymentFileReceiptService(PaymentFileReceiptRepo repository) {
        super(repository);
        this.repository = repository;
    }

    public PaymentFileReceipt findByUuid(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new PaymentFileReceiptNotFoundException(uuid));
    }
}
