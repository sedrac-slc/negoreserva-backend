package com.negoreserva.common.feature.concrete.user.dto.request.post;

import jakarta.validation.constraints.*;


public record UserResetPasswordCurrentRequest(
        @NotBlank(message = "Current password is required")
        String current,

        @NotBlank(message = "Password is required")
        @Size(min = 6)
        String password,

        @NotBlank(message = "Confirm password is required")
        @Size(min = 6)
        String confirm
) {

}
