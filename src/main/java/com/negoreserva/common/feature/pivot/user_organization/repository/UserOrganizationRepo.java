package com.negoreserva.common.feature.pivot.user_organization.repository;

import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.feature.pivot.user_organization.model.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserOrganizationRepo extends JpaRepository<UserOrganization, Long> {
    Optional<UserOrganization> findByOrganizationAndUser(Organization organization, User user);
}
