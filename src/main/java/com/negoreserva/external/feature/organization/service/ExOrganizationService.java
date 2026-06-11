package com.negoreserva.external.feature.organization.service;

import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.common.feature.concrete.category.repository.CategoryRepo;
import com.negoreserva.common.feature.concrete.organization.enums.OrganizationStatus;
import com.negoreserva.common.feature.concrete.organization.exception.notfound.OrganizationNotFoundException;
import com.negoreserva.common.feature.concrete.organization.exception.notfound.OrganizationSlugNotFoundException;
import com.negoreserva.common.feature.concrete.organization.dto.queryparam.OrganizationSearchFilterParam;
import com.negoreserva.common.feature.concrete.organization.dto.response.OrganizationResponse;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.organization.repository.OrganizationRepository;
import com.negoreserva.common.util.RegexValidators;
import com.negoreserva.external.feature.organization.dto.response.ExtGetOrganizationPaginate;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.external.feature.organization.query.OrganizationSearchSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExOrganizationService {
    private final OrganizationRepository organizationRepository;
    private final CategoryRepo categoryRepo;

    public ExtGetOrganizationPaginate paginate(PaginateRequest paginateRequest) {
        return paginate(PageRequest.of(paginateRequest.pageNumber(), paginateRequest.pageSize()));
    }

    public ExtGetOrganizationPaginate paginate(Pageable pageable) {
        var organizations = organizationRepository.findAllByStatus(OrganizationStatus.VISIBLE, pageable);
        return ExtGetOrganizationPaginate.of(organizations);
    }

    public ExtGetOrganizationPaginate paginate(List<UUID> categoryUuids, Pageable pageable) {
        var categories = categoryRepo.findByUuidIn(categoryUuids);
        var categoryIds = categories.stream().map(Category::getId).toList();
        var organizations = organizationRepository.findAllByStatusAndCategoriesIdIn(OrganizationStatus.VISIBLE, categoryIds, pageable);
        return ExtGetOrganizationPaginate.of(organizations);
    }

    public Organization findByUuid(UUID uuid) {
        return organizationRepository.findByUuid(uuid).orElseThrow(() -> new OrganizationNotFoundException(uuid));
    }

    public Organization findBySlug(String slug) {
        return organizationRepository.findBySlug(slug).orElseThrow(() -> new OrganizationSlugNotFoundException(slug));
    }

    public Organization findByUuidOrSlug(String uuidOrSlug) {
        return RegexValidators.isUuid(uuidOrSlug) ? findByUuid(UUID.fromString(uuidOrSlug)) : findBySlug(uuidOrSlug);
    }

    public Page<OrganizationResponse> search(String query, Pageable pageable) {
        return organizationRepository.findByLikeContact(query, pageable)
                .map(Organization::toResponse);
    }

    public Page<OrganizationResponse> search(OrganizationSearchFilterParam filter, Pageable pageable) {
        var spec = new OrganizationSearchSpecification(filter);
        return organizationRepository.findAll(spec, pageable)
                .map(Organization::toResponse);
    }
}
