package com.negoreserva.common.feature.concrete.transaction.model;

import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.concrete.transaction.dto.response.TransactionResponse;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.feature.core.model.ConcreteModel;
import com.negoreserva.common.variable.EntityVariable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.security.SecureRandom;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = EntityVariable.TRANSACTION)
public class Transaction extends ConcreteModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Positive
    private Integer amount;

    @NotNull
    @PositiveOrZero
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(unique = true, updatable = false, nullable = false)
    private String code;

    private static final String CODE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    @PrePersist
    public void onCreate() {
        super.onCreate();
        if (code == null) {
            StringBuilder sb = new StringBuilder("TS");
            for (int i = 0; i < 10; i++) {
                sb.append(CODE_CHARS.charAt(RANDOM.nextInt(CODE_CHARS.length())));
            }
            code = sb.toString();
        }
    }

    public TransactionResponse toResponse() {
        return new TransactionResponse(uuid, code, product.toResponse(), user.toResponse(), amount, price);
    }
}
