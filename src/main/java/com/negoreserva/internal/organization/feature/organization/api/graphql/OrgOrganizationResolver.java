package com.negoreserva.internal.organization.feature.organization.api.graphql;

import com.negoreserva.common.feature.concrete.organization.dto.request.OrganizationAddressEditRequest;
import com.negoreserva.common.feature.concrete.organization.dto.request.OrganizationEditProfileRequest;
import com.negoreserva.common.feature.concrete.organization_social_media.dto.request.OrganizationSocialMediaEditRequest;
import com.negoreserva.internal.organization.feature.organization.dto.response.OrgOrganizationProfile;
import com.negoreserva.internal.organization.feature.organization.service.OrgOrganizationService;
import com.negoreserva.common.feature.concrete.organization.dto.response.OrganizationResponse;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrgOrganizationResolver {
    private final OrgOrganizationService organizationService;

    @QueryMapping
    public OrgOrganizationProfile orgProfileOrganization(Authentication authentication) {
        return organizationService.orgProfileOrganization(authentication);
    }

    @MutationMapping
    public OrganizationResponse orgOrganizationUpdate(@Argument OrganizationEditProfileRequest request, Authentication authentication) {
        return organizationService.update(request, authentication).toResponse();
    }

    @MutationMapping
    public OrganizationResponse orgOrganizationUpdateSocialMedia(@Argument OrganizationSocialMediaEditRequest request, Authentication authentication) {
        return organizationService.updateSocialMedia(request, authentication).toResponse();
    }

    @MutationMapping
    public OrganizationResponse orgOrganizationUpdateAddress(@Argument OrganizationAddressEditRequest request, Authentication authentication) {
        return organizationService.updateAddress(request, authentication).toResponse();
    }
}
