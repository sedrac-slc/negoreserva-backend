package com.negoreserva.common.feature.general.register.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ResendUserOtpVerificationRequest",
        description = "DTO used to request resending a user OTP verification code"
)
public record ResendUserOtpVerificationRequest(
        @Schema(description = "Unique identifier of the previously generated OTP", example = "a3f5c9d2-code-789")
        String otpId,
        @Schema(description = "Unique identifier of the user requesting the OTP resend", example = "user-12345")
        String userId
) {
}