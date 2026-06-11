package com.negoreserva.common.feature.general.user_forget_password.dto.request;

public record UserForgetResetPasswordRequest(
        String code,
        String password,
        String confirm
) {
}
