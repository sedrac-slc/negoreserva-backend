package com.negoreserva.common.feature.pivot.user_organization.service;

import com.negoreserva.common.feature.pivot.user_organization.model.UserOrganization;
import com.negoreserva.common.feature.pivot.user_organization.repository.UserOrganizationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserOrganizationService {
    private final UserOrganizationRepo userOrganizationRepo;

    @Transactional
    public UserOrganization save(UserOrganization userOrganization) {
        return userOrganizationRepo.save(userOrganization);
    }

    public UserOrganization findOrCreate(UserOrganization userOrganization) {
        return userOrganizationRepo.findByOrganizationAndUser(userOrganization.getOrganization(), userOrganization.getUser())
                .orElseGet(() -> save(userOrganization));
    }
}
