package com.negoreserva.common.feature.core.variable;

import java.util.function.Supplier;

public record ConstraintsUniqueItem(
        String key,
        String message,
        Supplier<RuntimeException> exception
) { }