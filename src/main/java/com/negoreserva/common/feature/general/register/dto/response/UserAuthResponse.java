package com.negoreserva.common.feature.general.register.dto.response;

import com.negoreserva.common.feature.concrete.user.enums.UserStatus;
import com.negoreserva.common.feature.concrete.user.enums.UserType;

import java.time.Instant;

public record UserAuthResponse(
        String token,
        String name,
        String email,
        UserType type,
        UserStatus status,
        String logo,
        Instant expiredAt
) { }
