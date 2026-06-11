package com.negoreserva.common.feature.concrete.user.dto.request.post;

import com.negoreserva.common.feature.concrete.user.model.User;
import lombok.Data;

@Data
public class UserEditProfileRequest {
    private String name;

    public User toModel() {
        return User.builder()
                .name(name)
                .build();
    }
}
