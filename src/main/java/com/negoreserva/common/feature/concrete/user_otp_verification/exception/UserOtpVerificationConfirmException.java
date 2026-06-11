package com.negoreserva.common.feature.concrete.user_otp_verification.exception;

public class UserOtpVerificationConfirmException extends RuntimeException {

    public UserOtpVerificationConfirmException() {
        super("User code verification");
    }
}
