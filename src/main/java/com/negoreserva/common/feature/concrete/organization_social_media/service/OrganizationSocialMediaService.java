package com.negoreserva.common.feature.concrete.organization_social_media.service;

import com.negoreserva.common.feature.concrete.organization.service.OrganizationService;
import com.negoreserva.common.feature.concrete.organization_social_media.dto.response.OrganizationSocialMediaPaginate;
import com.negoreserva.common.feature.concrete.organization_social_media.repository.OrganizationSocialMediaRepo;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.organization_social_media.exception.notfound.OrganizationSocialMediaNotFoundException;
import com.negoreserva.common.feature.concrete.organization_social_media.model.OrganizationSocialMedia;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.common.feature.core.service.ConcreteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationSocialMediaService extends ConcreteService<OrganizationSocialMedia> {
    private final OrganizationSocialMediaRepo repository;
    private final OrganizationService organizationService;

    public OrganizationSocialMediaService(
            OrganizationSocialMediaRepo repository,
            OrganizationService organizationService
    ) {
        super(repository);
        this.repository = repository;
        this.organizationService = organizationService;
    }

    public boolean existsByOrganization(Organization organization) {
        return repository.existsByOrganization(organization);
    }

    public OrganizationSocialMediaPaginate paginate(Pageable pageable) {
        var page = repository.findAll(pageable);
        return OrganizationSocialMediaPaginate.of(page);
    }

    public OrganizationSocialMediaPaginate paginate(PaginateRequest paginateRequest) {
        return paginate(PageRequest.of(paginateRequest.pageNumber(), paginateRequest.pageSize()));
    }

    public OrganizationSocialMedia findByUuid(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new OrganizationSocialMediaNotFoundException(uuid));
    }

    public OrganizationSocialMedia save(OrganizationSocialMedia organizationSocialMedia, UUID organizationUuid) {
        if (organizationUuid != null) {
            Organization organization = organizationService.findByUuid(organizationUuid);
            organizationSocialMedia.setOrganization(organization);
        }
        return save(organizationSocialMedia);
    }

    public OrganizationSocialMedia update(UUID uuid, OrganizationSocialMedia organizationSocialMedia, UUID organizationUuid) {
        var item = findByUuid(uuid);
        item.setFacebook(organizationSocialMedia.getFacebook());
        item.setInstagram(organizationSocialMedia.getInstagram());
        item.setYoutube(organizationSocialMedia.getYoutube());
        item.setTiktok(organizationSocialMedia.getTiktok());
        item.setLinkedin(organizationSocialMedia.getLinkedin());

        if (organizationUuid != null) {
            Organization organization = organizationService.findByUuid(organizationUuid);
            item.setOrganization(organization);
        }

        return repository.save(item);
    }

    @Override
    public OrganizationSocialMedia update(UUID uuid, OrganizationSocialMedia organizationSocialMedia) {
        var item = findByUuid(uuid);
        item.setFacebook(organizationSocialMedia.getFacebook());
        item.setInstagram(organizationSocialMedia.getInstagram());
        item.setYoutube(organizationSocialMedia.getYoutube());
        item.setTiktok(organizationSocialMedia.getTiktok());
        item.setLinkedin(organizationSocialMedia.getLinkedin());
        return repository.save(item);
    }
}
