package com.negoreserva.internal.organization.feature.user_role.service;

import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.feature.pivot.org_user_role.model.OrgUserRole;
import com.negoreserva.internal.organization.feature.user_role.repository.OrgUserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrgUserRoleService {
    private final OrgUserRoleRepository repository;

    @Transactional
    public void sync(User user, OrgRole role) {
        repository.deleteByUser(user);
        if (role != null) {
            repository.save(OrgUserRole.builder().user(user).role(role).build());
        }
    }
}
