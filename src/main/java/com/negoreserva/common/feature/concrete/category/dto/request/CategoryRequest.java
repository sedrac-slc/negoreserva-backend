package com.negoreserva.common.feature.concrete.category.dto.request;

import com.negoreserva.common.feature.concrete.category.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank
        @Size(max = 100)
        String name,
        @NotBlank
        @Size(max = 255)
        String description,
        @Size(max = 255)
        String icon
) {
    public Category toModel() {
        return Category.builder()
                .name(name)
                .description(description)
                .icon(icon)
                .build();
    }
}