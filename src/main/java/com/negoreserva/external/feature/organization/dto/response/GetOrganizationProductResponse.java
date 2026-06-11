package com.negoreserva.external.feature.organization.dto.response;

import com.negoreserva.external.feature.product.dto.response.ProductGetOrganizationResponse;
import com.negoreserva.external.feature.product_file.dto.response.ProductFileGetOrgResponse;
import com.negoreserva.external.feature.product_price.dto.response.ProductPriceGetOrgResponse;
import com.negoreserva.external.feature.product_tag_info.response.ProductTagInfoGetOrgResponse;

import java.util.List;

public record GetOrganizationProductResponse(
        ProductGetOrganizationResponse product,
        List<ProductFileGetOrgResponse> files,
        List<ProductTagInfoGetOrgResponse> tags,
        List<ProductPriceGetOrgResponse> prices
) {
}
