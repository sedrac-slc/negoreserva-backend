package com.negoreserva.common.feature.concrete.role.enums;

import com.negoreserva.common.feature.concrete.role.model.Role;
import com.negoreserva.common.feature.concrete.role.model.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

@Getter
@AllArgsConstructor
public enum RoleData {
    ADMIN(Role.builder().code("ADMIN").name("Administrator").description("System administrator").roleType(RoleType.ADMIN).build()),

    ADMIN_CLIENT(Role.builder().code("ADMIN_CLIENT").name("Administrator client").description("System administrator of client").roleType(RoleType.CLIENT).build()),
    CLIENT(Role.builder().code("CLIENT").name("Client").description("Regular client").roleType(RoleType.CLIENT).build());

    private final Role role;

    public static List<Role> listRoles() {
        return Arrays.stream(RoleData.values()).map(RoleData::getRole).toList();
    }

    public static Role random() {
        var roles = listRoles();
        var random = RandomGenerator.getDefault();
        var index = random.nextInt(roles.size());
        return roles.get(index);
    }
}
