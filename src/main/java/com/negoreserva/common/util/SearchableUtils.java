package com.negoreserva.common.util;


public final class SearchableUtils {
    public static String createField(String... fields) {
        return String.join("#@#", fields);
    }
}
