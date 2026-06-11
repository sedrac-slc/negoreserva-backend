package com.negoreserva.common.feature.concrete.payment.dto.response;

import com.negoreserva.common.feature.concrete.payment.enums.PaymentMethod;
import com.negoreserva.common.feature.concrete.payment.enums.PaymentStatus;
import com.negoreserva.common.feature.concrete.payment.model.Payment;
import com.negoreserva.common.feature.concrete.transaction.dto.response.TransactionResponse;

import java.util.UUID;

public record PaymentResponse(
        UUID uuid,
        TransactionResponse transaction,
        PaymentStatus status,
        PaymentMethod type
) {
    public static PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(
                payment.getUuid(),
                TransactionResponse.of(payment.getTransaction()),
                payment.getStatus(),
                payment.getType()
        );
    }
}
