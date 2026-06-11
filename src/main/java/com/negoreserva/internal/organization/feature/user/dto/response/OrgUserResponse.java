package com.negoreserva.internal.organization.feature.user.dto.response;

import com.negoreserva.common.feature.concrete.user.model.User;

import java.util.UUID;

public record OrgUserResponse(UUID uuid, String name, String email, String phone, String birthday) {
    public static OrgUserResponse of(User user) {
        return new OrgUserResponse(
                user.getUuid(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getBirthday() == null ? null : user.getBirthday().toString()
        );
    }
}
