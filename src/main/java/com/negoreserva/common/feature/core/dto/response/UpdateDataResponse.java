package com.negoreserva.common.feature.core.dto.response;

import com.negoreserva.common.feature.core.enums.UpdateDataType;

import java.time.Instant;

public record UpdateDataResponse(
        String id,
        String field,
        UpdateDataType type,
        Instant expiredAt
) { }
