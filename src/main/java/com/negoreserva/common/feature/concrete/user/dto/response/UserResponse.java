package com.negoreserva.common.feature.concrete.user.dto.response;

import java.util.UUID;

public record UserResponse(UUID uuid, String name, String email, String phone) { }
