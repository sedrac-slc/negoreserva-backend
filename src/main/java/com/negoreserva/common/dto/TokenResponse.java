package com.negoreserva.common.dto;

import java.time.Instant;

public record TokenResponse(String token, Instant expiredAt) { }
