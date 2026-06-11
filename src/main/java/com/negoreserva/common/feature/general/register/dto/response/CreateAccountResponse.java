package com.negoreserva.common.feature.general.register.dto.response;

import java.time.Instant;

public record CreateAccountResponse(
        String otpId,
        String userId,
        Instant otpExpiredAt,
        String token,
        Instant expiredAt,
        boolean status
) {
}
