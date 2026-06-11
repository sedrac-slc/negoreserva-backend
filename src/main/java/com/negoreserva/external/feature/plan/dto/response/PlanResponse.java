package com.negoreserva.internal.admin.feature.plan.dto.response;

import com.negoreserva.common.feature.concrete.plan.enums.PlanType;

import java.math.BigDecimal;
import java.util.UUID;

public record PlanResponse(UUID uuid, String name, BigDecimal price, String description, PlanType type) { }
