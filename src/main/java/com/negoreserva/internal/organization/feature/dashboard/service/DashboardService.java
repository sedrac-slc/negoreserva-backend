package com.negoreserva.internal.organization.feature.dashboard.service;

import com.negoreserva.common.feature.concrete.catalog.model.Catalog;
import com.negoreserva.common.feature.concrete.catalog.repository.CatalogRepo;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.organization.usecase.OrgOrganizationUseCase;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.concrete.product.repository.ProductRepository;
import com.negoreserva.common.feature.concrete.user.service.UserService;
import com.negoreserva.common.feature.pivot.catalog_products.model.CatalogProducts;
import com.negoreserva.common.feature.pivot.catalog_products.service.CatalogProductsService;
import com.negoreserva.internal.organization.feature.catalog.dto.response.OrgCatalogResponse;
import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardCatalogWithProductCount;
import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardTotals;
import com.negoreserva.internal.organization.feature.payment.dto.response.OrgPaymentResponse;
import com.negoreserva.internal.organization.feature.payment.repository.OrgPaymentRepo;
import com.negoreserva.internal.organization.feature.product.dto.response.OrgProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardPaymentByMethod;
import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardPaymentByStatus;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final ProductRepository productRepository;
    private final CatalogRepo catalogRepo;
    private final OrgPaymentRepo orgPaymentRepo;
    private final CatalogProductsService catalogProductsService;
    private final UserService userService;

    public Organization find(Authentication authentication) {
        var usecase = new OrgOrganizationUseCase(authentication, userService);
        return usecase.applyUseCase();
    }

    public DashboardTotals totals(Authentication authentication) {
        var org = find(authentication);
        var totalProducts = (int) productRepository.findAllByOrganization(org, Pageable.unpaged()).getTotalElements();
        var totalCatalogs = (int) catalogRepo.findAllByOrganization(org, Pageable.unpaged()).getTotalElements();
        var totalPayments = (int) orgPaymentRepo.countByOrganization(org);
        return new DashboardTotals(totalProducts, totalPayments, totalCatalogs);
    }

    public List<DashboardCatalogWithProductCount> catalogsWithProductCount(Authentication authentication) {
        var org = find(authentication);
        var catalogs = catalogRepo.findAllByOrganization(org, PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.DESC, "createdAt"))).getContent();
        return catalogs.stream().map(catalog -> {
            var products = catalogProductsService.findAllByCatalog(catalog);
            return new DashboardCatalogWithProductCount(
                catalog.getUuid(),
                catalog.getName(),
                catalog.getDescription(),
                catalog.getImgUrl(),
                catalog.getSlug(),
                products.size()
            );
        }).toList();
    }

    public List<OrgPaymentResponse> recentPayments(int pageSize, Authentication authentication) {
        var org = find(authentication);
        return orgPaymentRepo.findAllByOrganizationOrderByCreatedAtDesc(org).stream()
            .limit(pageSize)
            .map(OrgPaymentResponse::toResponse)
            .toList();
    }

    public List<OrgProductResponse> recentProducts(int pageSize, Authentication authentication) {
        var org = find(authentication);
        var pageable = PageRequest.of(0, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        return productRepository.findAllByOrganization(org, pageable).stream()
            .map(OrgProductResponse::toResponse)
            .toList();
    }

    public List<OrgCatalogResponse> recentCatalogs(int pageSize, Authentication authentication) {
        var org = find(authentication);
        var pageable = PageRequest.of(0, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        return catalogRepo.findAllByOrganization(org, pageable).stream()
            .map(OrgCatalogResponse::toResponse)
            .toList();
    }

    public List<DashboardPaymentByStatus> paymentsByStatus(Authentication authentication) {
        var org = find(authentication);
        return orgPaymentRepo.countByStatusGroupedByOrganization(org).stream()
            .map(row -> new DashboardPaymentByStatus(
                ((Enum<?>) row[0]).name(),
                (long) row[1]
            ))
            .toList();
    }

    public List<DashboardPaymentByMethod> paymentsByMethod(Authentication authentication) {
        var org = find(authentication);
        return orgPaymentRepo.countByMethodGroupedByOrganization(org).stream()
            .map(row -> new DashboardPaymentByMethod(
                ((Enum<?>) row[0]).name(),
                (long) row[1]
            ))
            .toList();
    }
}
