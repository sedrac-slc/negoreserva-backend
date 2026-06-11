package com.negoreserva.common.feature.concrete.transaction.dto.request;

import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.concrete.transaction.model.Transaction;
import com.negoreserva.common.feature.concrete.user.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequest(
        @NotNull UUID productUuid,
        @NotNull UUID userUuid,
        @NotNull @Positive Integer amount,
        @NotNull @PositiveOrZero BigDecimal price
) {
    public Transaction toModel(Product product, User user) {
        return Transaction.builder()
                .product(product).user(user).amount(amount).price(price)
                .build();
    }
}
