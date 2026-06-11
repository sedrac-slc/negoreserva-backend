package com.negoreserva.common.feature.core.dto.response;

import java.util.List;

public record ProblemDetailsResponse(
        String detail,
        String instance,
        int status,
        String title,
        List<String> errors
) {
}
