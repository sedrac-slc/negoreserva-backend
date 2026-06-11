package com.negoreserva.common.feature.concrete.payment.dto.request;

import com.negoreserva.common.feature.concrete.payment.enums.PaymentMethod;
import com.negoreserva.common.feature.concrete.payment.model.Payment;
import com.negoreserva.common.feature.concrete.transaction.model.Transaction;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PaymentRequest(
        @NotNull UUID transactionUuid,
        PaymentMethod type
) {
    public Payment toModel(Transaction transaction) {
        return Payment.builder()
                .transaction(transaction)
                .type(type != null ? type : PaymentMethod.NONE)
                .build();
    }
}
