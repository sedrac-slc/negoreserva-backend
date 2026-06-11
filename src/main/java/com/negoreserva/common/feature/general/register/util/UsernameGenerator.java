package com.negoreserva.common.feature.general.register.util;

import java.text.Normalizer;

public final class UsernameGenerator {

    public static String generate(String name) {
        return normalize(name) + "#nego";
    }

    private static String normalize(String name) {
        return Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase()
                .replaceAll("\\s+", ".");
    }

}
