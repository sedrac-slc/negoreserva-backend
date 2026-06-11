package com.negoreserva.external.feature.organization.mapper;

import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.external.feature.organization.dto.response.GetOrganizationProductResponse;
import com.negoreserva.external.feature.product.mapper.ProductGetOrganizationMapper;
import com.negoreserva.external.feature.product_file.mapper.ProductFileGetOrganizationMapper;
import com.negoreserva.external.feature.product_price.mapper.ProductPriceGetOrganizationMapper;
import com.negoreserva.external.feature.product_tag_info.mapper.ProductTagInfoGetOrganizationResponseMapper;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetOrganizationProductMapper {
    private Organization organization;

    public List<GetOrganizationProductResponse> toResponse() {
        return organization.getProducts().stream().map(this::toMapper).toList();
    }

    private GetOrganizationProductResponse toMapper(Product product) {
        var item = new ProductGetOrganizationMapper(product);
        var tags = product.getProductTagInfos();
        var files = product.getProductFiles();
        var prices = product.getProductPrices();

        return new GetOrganizationProductResponse(
                item.toResponse(),

                files.stream()
                        .map(ProductFileGetOrganizationMapper::new)
                        .map(ProductFileGetOrganizationMapper::toResponse)
                        .toList(),

                tags.stream()
                        .map(ProductTagInfoGetOrganizationResponseMapper::new)
                        .map(ProductTagInfoGetOrganizationResponseMapper::toResponse)
                        .toList(),

                prices.stream()
                        .map(ProductPriceGetOrganizationMapper::new)
                        .map(ProductPriceGetOrganizationMapper::toResponse)
                        .toList()
        );
    }
}
