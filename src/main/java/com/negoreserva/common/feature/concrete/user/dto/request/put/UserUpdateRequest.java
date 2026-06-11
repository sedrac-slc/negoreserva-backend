package com.negoreserva.common.feature.concrete.user.dto.request.put;

import com.negoreserva.common.feature.concrete.user.model.User;

import java.time.LocalDate;

public record UserUpdateRequest(String name, LocalDate birthday) {
    public User toModel() {
        return User.builder()
                .name(name)
                .birthday(birthday)
                .build();
    }
}
