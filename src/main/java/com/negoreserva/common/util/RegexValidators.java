package com.negoreserva.common.util;

public final class RegexValidators {
    public static final String PATTERN_PHONE = "^\\+?[0-9]{7,15}$";

    public static boolean isUuid(String text) {
        if (text.length() != 36) return false;
        return text.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
    }
}
