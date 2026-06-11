package com.negoreserva.common.feature.general.register.util;


import java.security.SecureRandom;

public final class OtpGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generate() {
        int otp = RANDOM.nextInt(900_000) + 100_000;
        return String.valueOf(otp);
    }

}
