package com.negoreserva.internal.organization.feature.dashboard.api.graphql;

import com.negoreserva.internal.organization.feature.catalog.dto.response.OrgCatalogResponse;
import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardCatalogWithProductCount;
import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardPaymentByMethod;
import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardPaymentByStatus;
import com.negoreserva.internal.organization.feature.dashboard.dto.response.DashboardTotals;
import com.negoreserva.internal.organization.feature.dashboard.service.DashboardService;
import com.negoreserva.internal.organization.feature.payment.dto.response.OrgPaymentResponse;
import com.negoreserva.internal.organization.feature.product.dto.response.OrgProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashboardGraphql {
    private final DashboardService service;

    @QueryMapping
    public DashboardTotals orgDashboardTotals(Authentication authentication) {
        return service.totals(authentication);
    }

    @QueryMapping
    public List<DashboardCatalogWithProductCount> orgDashboardCatalogsWithProductCount(Authentication authentication) {
        return service.catalogsWithProductCount(authentication);
    }

    @QueryMapping
    public List<OrgPaymentResponse> orgDashboardRecentPayments(@Argument int pageSize, Authentication authentication) {
        return service.recentPayments(pageSize, authentication);
    }

    @QueryMapping
    public List<OrgProductResponse> orgDashboardRecentProducts(@Argument int pageSize, Authentication authentication) {
        return service.recentProducts(pageSize, authentication);
    }

    @QueryMapping
    public List<OrgCatalogResponse> orgDashboardRecentCatalogs(@Argument int pageSize, Authentication authentication) {
        return service.recentCatalogs(pageSize, authentication);
    }

    @QueryMapping
    public List<DashboardPaymentByStatus> orgDashboardPaymentsByStatus(Authentication authentication) {
        return service.paymentsByStatus(authentication);
    }

    @QueryMapping
    public List<DashboardPaymentByMethod> orgDashboardPaymentsByMethod(Authentication authentication) {
        return service.paymentsByMethod(authentication);
    }
}
