package com.negoreserva.common.feature.concrete.org_role.component;

import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import com.negoreserva.internal.organization.feature.role.service.OrgRoleService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class OrgRoleSeeder {
    private final OrgRoleService service;

    public OrgRoleSeeder(OrgRoleService service) {
        this.service = service;
    }

    @Transactional
    public List<OrgRole> seed() {
        Map<String, String> roles = Map.of(
                "ADMIN", "Administrador da organização com acesso completo às funcionalidades internas.",
                "EMPLOYEE", "Colaborador da organização com acesso operacional conforme permissões atribuídas."
        );

        return roles.entrySet().stream()
                .map(entry -> service.findOrCreate(OrgRole.builder()
                        .name(entry.getKey())
                        .description(entry.getValue())
                        .build()))
                .toList();
    }
}
