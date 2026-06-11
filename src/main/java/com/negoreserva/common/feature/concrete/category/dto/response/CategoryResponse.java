package com.negoreserva.common.feature.concrete.category.dto.response;

import com.negoreserva.common.feature.concrete.category.model.Category;

import java.util.UUID;

public record CategoryResponse(UUID uuid, String name, String slug, String description, String icon) {

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(
          category.getUuid(),
          category.getName(),
          category.getSlug(),
          category.getDescription(),
          category.getIcon()
        );
    }

}