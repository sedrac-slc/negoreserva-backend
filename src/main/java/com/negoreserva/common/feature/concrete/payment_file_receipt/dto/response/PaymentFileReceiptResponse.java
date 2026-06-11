package com.negoreserva.common.feature.concrete.payment_file_receipt.dto.response;

import com.negoreserva.common.feature.concrete.payment_file_receipt.model.PaymentFileReceipt;

import java.time.Instant;
import java.util.UUID;

public record PaymentFileReceiptResponse(UUID uuid, UUID paymentUuid, String fileUrl, String type, Long size, Instant createdAt) {
    public static PaymentFileReceiptResponse of(PaymentFileReceipt receipt) {
        return new PaymentFileReceiptResponse(
                receipt.getUuid(),
                receipt.getPayment().getUuid(),
                receipt.getFileUrl(),
                receipt.getType(),
                receipt.getSize(),
                receipt.getCreatedAt()
        );
    }
}
