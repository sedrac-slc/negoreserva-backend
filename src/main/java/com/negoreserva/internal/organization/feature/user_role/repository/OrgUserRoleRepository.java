package com.negoreserva.internal.organization.feature.user_role.repository;

import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.feature.pivot.org_user_role.model.OrgUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgUserRoleRepository extends JpaRepository<OrgUserRole, Long> {
    void deleteByUser(User user);
}
