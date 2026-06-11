package com.negoreserva.common.util;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public final class SlugUtils {

    private static final Pattern NON_LATIN = Pattern.compile("[^a-z0-9]+");
    private static final Pattern DIACRITICS = Pattern.compile("\\p{M}");
    private static final Pattern EDGE_HYPHENS = Pattern.compile("^-|-$");

    public static String toSlug(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        var normalized = Normalizer.normalize(input, Normalizer.Form.NFD);

        var slug = DIACRITICS.matcher(normalized)
                .replaceAll("")
                .toLowerCase(Locale.ROOT)
                .trim()
                .replace("'", "");

        slug = NON_LATIN.matcher(slug)
                .replaceAll("-");

        return EDGE_HYPHENS.matcher(slug)
                .replaceAll("");
    }
}
