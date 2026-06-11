package com.negoreserva.internal.admin.feature.role.component;

import com.negoreserva.common.feature.concrete.role.dto.response.RoleResponse;
import com.negoreserva.common.feature.concrete.role.enums.RoleData;
import com.negoreserva.internal.admin.feature.role.service.AdminRoleService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminRoleSeeder {
    private final AdminRoleService adminRoleService;
    private final List<RoleResponse> items = new ArrayList<>();

    public AdminRoleSeeder(AdminRoleService adminRoleService) {
        this.adminRoleService = adminRoleService;
    }

    public List<RoleResponse> items() { return items; }

    @Transactional
    public void seed() {
        for (RoleData role : RoleData.values()) {
            items.add(adminRoleService.findOrCreate(role.getRole()).toResponse());
        }
    }
}
