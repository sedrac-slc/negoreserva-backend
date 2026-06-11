package com.negoreserva.internal.organization.feature.user.dto.request;

import com.negoreserva.common.feature.concrete.user.model.User;

import java.time.LocalDate;

public record OrgUserUpdateRequest(String name, LocalDate birthday) {
    public User toModel() {
        return User.builder().name(name).birthday(birthday).build();
    }
}
