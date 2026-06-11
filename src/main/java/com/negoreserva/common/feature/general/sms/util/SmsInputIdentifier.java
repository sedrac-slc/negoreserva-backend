package com.negoreserva.common.feature.general.sms.util;

import java.util.regex.Pattern;

public final class SmsInputIdentifier {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+?[0-9]{9,15}$");

    private SmsInputIdentifier() {}

    public static boolean isEmail(String input) {
        return EMAIL_PATTERN.matcher(input).matches();
    }

    public static boolean isPhone(String input) {
        return PHONE_PATTERN.matcher(input).matches();
    }
}
