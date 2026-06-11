package com.negoreserva.internal.organization.feature.catalog.service;

import com.negoreserva.common.exception.NotFoundException;
import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.catalog.repository.CatalogRepo;
import com.negoreserva.common.feature.concrete.catalog.service.CatalogService;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.organization.usecase.OrgOrganizationUseCase;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.concrete.product.repository.ProductRepository;
import com.negoreserva.common.feature.concrete.user.service.UserService;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.common.feature.general.storage.service.StorageService;
import com.negoreserva.common.feature.pivot.catalog_products.service.CatalogProductsService;
import com.negoreserva.internal.organization.feature.catalog.dto.queryparam.CatalogFilterQueryParam;
import com.negoreserva.internal.organization.feature.catalog.dto.response.OrgCatalogPaginate;
import com.negoreserva.internal.organization.feature.catalog.query.CatalogFilterSpecification;
import com.negoreserva.internal.organization.feature.product.dto.response.OrgProductPaginate;
import com.negoreserva.internal.organization.feature.product.dto.response.OrgProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrgCatalogService {
    private final CatalogService catalogService;
    private final CatalogRepo catalogRepo;
    private final CatalogProductsService catalogProductsService;
    private final ProductRepository productRepository;
    private final StorageService uploadFileService;
    private final UserService userService;

    public Organization find(Authentication authentication) {
        var usecase = new OrgOrganizationUseCase(authentication, userService);
        return usecase.applyUseCase();
    }

    public OrgCatalogPaginate paginate(Pageable pageable, Authentication authentication) {
        var organization = find(authentication);
        Page<Catalog> page = catalogRepo.findAllByOrganization(organization, pageable);
        return OrgCatalogPaginate.of(page);
    }

    public OrgCatalogPaginate paginate(PaginateRequest paginateRequest, Authentication authentication) {
        return paginate(PageRequest.of(paginateRequest.pageNumber(), paginateRequest.pageSize()), authentication);
    }

    public OrgCatalogPaginate paginate(CatalogFilterQueryParam filter, Authentication authentication) {
        var pageRequest = PageRequest.of(
            Optional.of(filter.getPageNumber()).orElse(0),
            Optional.of(filter.getPageSize()).orElse(10)
        );
        var spec = new CatalogFilterSpecification(filter);
        var organization = find(authentication);
        var page = catalogRepo.findAllByOrganization(organization, spec, pageRequest);
        return OrgCatalogPaginate.of(page);
    }

    public Catalog findByUuid(UUID uuid) {
        return catalogRepo.findByUuid(uuid).orElseThrow(NotFoundException::new);
    }

    public Catalog findByUuidOrSlug(String uuidOrSlug) {
        return catalogService.findByUuidOrSlug(uuidOrSlug);
    }

    public OrgProductPaginate paginateCatalogProducts(String uuidOrSlug, Pageable pageable, Authentication authentication) {
        var organization = find(authentication);
        var catalog = catalogService.findByUuidOrSlug(uuidOrSlug);
        var page = catalogProductsService.findAllByCatalog(catalog, pageable);
        var products = page.getContent().stream().map(cp -> OrgProductResponse.toResponse(cp.getProduct())).toList();
        return new OrgProductPaginate(
            products, page.isEmpty(), page.isFirst(), page.isLast(),
            page.getNumber(), page.getNumberOfElements(), page.getSize(),
            page.getTotalElements(), page.getTotalPages()
        );
    }

    public OrgProductPaginate paginateProductsNotInCatalog(String uuidOrSlug, Pageable pageable, Authentication authentication) {
        var organization = find(authentication);
        var catalog = catalogService.findByUuidOrSlug(uuidOrSlug);
        var page = productRepository.findAllByOrganizationNotInCatalog(organization, catalog.getUuid(), pageable);
        return OrgProductPaginate.of(page);
    }

    @Transactional
    public void addProductsToCatalog(String uuidOrSlug, List<com.negoreserva.internal.organization.feature.catalog.dto.request.CatalogProductOrderInput> productOrders, Authentication authentication) {
        var organization = find(authentication);
        var catalog = catalogService.findByUuidOrSlug(uuidOrSlug);
        var products = productOrders.stream()
            .map(input -> productRepository.findByUuid(input.productUuid()).orElse(null))
            .filter(java.util.Objects::nonNull)
            .toList();
        var orderMap = productOrders.stream()
            .collect(java.util.stream.Collectors.toMap(
                com.negoreserva.internal.organization.feature.catalog.dto.request.CatalogProductOrderInput::productUuid,
                com.negoreserva.internal.organization.feature.catalog.dto.request.CatalogProductOrderInput::order
            ));
        catalogProductsService.addProductsWithOrder(catalog, products, orderMap);
    }

    @Transactional
    public void removeProductsFromCatalog(String uuidOrSlug, List<UUID> productUuids, Authentication authentication) {
        var organization = find(authentication);
        var catalog = catalogService.findByUuidOrSlug(uuidOrSlug);
        catalogProductsService.removeProducts(catalog, productUuids);
    }

    @Transactional
    public Catalog create(com.negoreserva.internal.organization.feature.catalog.dto.request.OrgCatalogCreateRequest dto, MultipartFile image, Authentication authentication) {
        var organization = find(authentication);
        Catalog catalog = new Catalog();
        catalog.setName(dto.name());
        catalog.setDescription(dto.description());
        catalog.setOrganization(organization);
        if (dto.type() != null) {
            catalog.setType(dto.type());
        }

        if (image != null && !image.isEmpty()) {
            String imgUrl = uploadFileService.uploadFile(image, "catalogs");
            catalog.setImgUrl(imgUrl);
        }

        return catalogService.save(catalog);
    }

    @Transactional
    public Catalog update(UUID uuid, com.negoreserva.internal.organization.feature.catalog.dto.request.OrgCatalogUpdateRequest dto) {
        Catalog catalog = catalogRepo.findByUuid(uuid).orElseThrow(NotFoundException::new);
        catalog.setName(dto.name());
        catalog.setDescription(dto.description());
        if (dto.type() != null) {
            catalog.setType(dto.type());
        }
        return catalogService.save(catalog);
    }

    @Transactional
    public Catalog updateImage(UUID uuid, MultipartFile image) {
        Catalog catalog = catalogRepo.findByUuid(uuid).orElseThrow(NotFoundException::new);
        String imgUrl = uploadFileService.uploadFile(image, "catalogs");
        catalog.setImgUrl(imgUrl);
        return catalogService.save(catalog);
    }

    @Transactional
    public void delete(UUID uuid) {
        catalogService.deleteByUuid(uuid);
    }

}
