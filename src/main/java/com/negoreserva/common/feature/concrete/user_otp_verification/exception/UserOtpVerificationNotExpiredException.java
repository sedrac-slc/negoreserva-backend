package com.negoreserva.common.feature.concrete.user_otp_verification.exception;

public class UserOtpVerificationNotExpiredException extends RuntimeException {

    public UserOtpVerificationNotExpiredException() {
        super("User code not expired");
    }
}
