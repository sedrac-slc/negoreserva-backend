package com.negoreserva.common.feature.concrete.transaction.dto.response;

import com.negoreserva.common.feature.concrete.product.dto.response.ProductResponse;
import com.negoreserva.common.feature.concrete.transaction.model.Transaction;
import com.negoreserva.common.feature.concrete.user.dto.response.UserResponse;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionResponse(UUID uuid, String code, ProductResponse product, UserResponse user, Integer amount, BigDecimal price) {
    public static TransactionResponse of(Transaction transaction) {
        return new TransactionResponse(
                transaction.getUuid(),
                transaction.getCode(),
                transaction.getProduct().toResponse(),
                transaction.getUser().toResponse(),
                transaction.getAmount(),
                transaction.getPrice()
        );
    }
}
