package com.negoreserva.common.feature.pivot.catalog_products.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.variable.EntityPivotVariable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(
    name = EntityPivotVariable.CATALOG_PRODUCTS,
    uniqueConstraints = {@UniqueConstraint(
        name = "uk_catalog_product",
        columnNames = {"catalog_id", "product_id"}
    )}
)
public class CatalogProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @Positive
    @Builder.Default
    @Column(name = "catalog_order")
    private Integer order = 1;
}
