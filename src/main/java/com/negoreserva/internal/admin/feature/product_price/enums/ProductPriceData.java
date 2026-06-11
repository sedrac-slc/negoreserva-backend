package com.negoreserva.internal.admin.feature.product_price.enums;

import com.negoreserva.common.feature.concrete.product.enums.ProductFaker;
import com.negoreserva.common.feature.concrete.product_price.model.ProductPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

@Getter
@AllArgsConstructor
public enum ProductPriceData {
    HOTEL_STANDARD_1_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("150.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_STANDARD_1.getProduct())
                    .build()
    ),
    HOTEL_STANDARD_2_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("250.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_STANDARD_2.getProduct())
                    .build()
    ),
    HOTEL_STANDARD_3_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("360.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_STANDARD_3.getProduct())
                    .build()
    ),
    HOTEL_TECHCORP_1_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("190.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_TECHCORP_1.getProduct())
                    .build()
    ),
    HOTEL_TECHCORP_2_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("250.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_TECHCORP_2.getProduct())
                    .build()
    ),
    HOTEL_TECHCORP_3_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("550.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_TECHCORP_3.getProduct())
                    .build()
    ),
    HOTEL_DELUXE_1_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("650.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_DELUXE_1.getProduct())
                    .build()
    ),
    HOTEL_DELUXE_2_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("475.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_DELUXE_2.getProduct())
                    .build()
    ),
    HOTEL_DELUXE_3_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("150.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.HOTEL_DELUXE_3.getProduct())
                    .build()
    ),

    // --- ACME PRESIDENTIAL ---
    ACME_PRESIDENTIAL_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("2500.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.ACME_PRESIDENTIAL.getProduct())
                    .build()
    ),

    // --- TECHCORP COWORKING ---
    TECHCORP_COWORKING_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("350.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.TECHCORP_COWORKING.getProduct())
                    .build()
    ),

    // --- GLOBAL EVENT SPACE ---
    GLOBAL_EVENT_SPACE_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("5000.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.GLOBAL_EVENT_SPACE.getProduct())
                    .build()
    ),

    // --- POUSADA RECANTO VERDE ---
    POUSADA_RUSTICO_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("320.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.POUSADA_QUARTO_RUSTICO.getProduct())
                    .build()
    ),
    POUSADA_SUITE_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("580.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.POUSADA_SUITE_MASTER.getProduct())
                    .build()
    ),
    POUSADA_CHALE_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("780.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.POUSADA_CHALE.getProduct())
                    .build()
    ),

    // --- PENSAO FAMILIAR ---
    PENSAO_SIMPLES_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("90.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.PENSAO_QUARTO_SIMPLES.getProduct())
                    .build()
    ),
    PENSAO_DUPLO_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("150.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.PENSAO_QUARTO_DUPLO.getProduct())
                    .build()
    ),
    PENSAO_SUITE_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("220.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.PENSAO_SUITE.getProduct())
                    .build()
    ),

    // --- RESTAURANTE SABOR & ARTE ---
    RESTAURANTE_JANTAR_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("180.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.RESTAURANTE_JANTAR_EXECUTIVO.getProduct())
                    .build()
    ),
    RESTAURANTE_CHEF_TABLE_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("450.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.RESTAURANTE_CHEF_TABLE.getProduct())
                    .build()
    ),
    RESTAURANTE_EVENTO_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("3000.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.RESTAURANTE_EVENTO.getProduct())
                    .build()
    ),

    // --- LOJA DO BAIRRO ---
    LOJA_CESTA_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("120.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.LOJA_CESTA_BASICA.getProduct())
                    .build()
    ),
    LOJA_HORTIFRUTI_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("65.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.LOJA_HORTIFRUTI.getProduct())
                    .build()
    ),
    LOJA_PRESENTES_NORMAL(
            ProductPrice.builder()
                    .value(new BigDecimal("250.00"))
                    .order(1)
                    .isPrimary(true)
                    .product(ProductFaker.LOJA_PRESENTES.getProduct())
                    .build()
    );

    private final ProductPrice productPrice;

    public static List<ProductPrice> listProductPrices() {
        return Arrays.stream(ProductPriceData.values()).map(ProductPriceData::getProductPrice).toList();
    }

    public static ProductPrice random() {
        var prices = listProductPrices();
        var random = RandomGenerator.getDefault();
        var index = random.nextInt(prices.size());
        return prices.get(index);
    }
}
