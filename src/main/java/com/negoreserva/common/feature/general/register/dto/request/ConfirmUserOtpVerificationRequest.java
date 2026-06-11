package com.negoreserva.common.feature.general.register.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ConfirmUserOtpVerificationRequest",
        description = "DTO used to confirm a user's OTP verification code"
)
public record ConfirmUserOtpVerificationRequest(
        @Schema(description = "Unique identifier of the OTP request", example = "a3f5c9d2-code-789")
        String otpId,
        @Schema(description = "One-time password (OTP) code sent to the user", example = "123456")
        String code
) {
}