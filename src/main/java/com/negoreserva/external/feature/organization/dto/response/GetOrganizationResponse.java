package com.negoreserva.external.feature.organization.dto.response;

import com.negoreserva.common.feature.concrete.category.dto.response.CategoryResponse;

import java.util.List;

public record GetOrganizationResponse(
        ExtOrganizationResponse organization,
        List<CategoryResponse> categories,
        List<GetOrganizationProductResponse> products
) { }



