package com.negoreserva.external.feature.organization.mapper;

import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.external.feature.organization.dto.response.GetOrganizationResponse;
import com.negoreserva.external.feature.organization.dto.response.ExtOrganizationResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetOrganizationMapper {
    private Organization organization;

    public GetOrganizationResponse toResponse() {
        var item =  ExtOrganizationResponse.of(organization);
        var mapper = new GetOrganizationProductMapper(organization);
        var categories = organization.getCategories().stream().map(Category::toResponse).toList();
        return new GetOrganizationResponse(item, categories, mapper.toResponse());
    }
}
