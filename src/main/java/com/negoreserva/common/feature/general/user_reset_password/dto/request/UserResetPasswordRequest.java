package com.negoreserva.common.feature.general.user_reset_password.dto.request;

public record UserResetPasswordRequest(
        String currentPassword,
        String newPassword,
        String confirmPassword
) {}
