package com.negoreserva.common.feature.concrete.organization_social_media.dto.request;

import java.util.UUID;

public record OrganizationSocialMediaRequest(
        UUID organizationUuid,
        String facebook,
        String instagram,
        String youtube,
        String titok,
        String linkedin
) {
}
