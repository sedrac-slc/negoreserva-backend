package com.negoreserva.common.util;

import java.util.UUID;

public final class UniqueFieldUtil {
    public static String fieldDelete(String text, long id) {
        return "%s#%s".formatted(text, id);
    }

    public static String fieldDelete(String text, UUID uuid) {
        return "%s#%s".formatted(text, uuid);
    }
}
