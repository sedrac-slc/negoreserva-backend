package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OmbalaSmsRequest(
        @NotBlank String message,
        @NotBlank String from,
        @NotBlank String to,
        @Nullable String schedule
) {
    public OmbalaSmsRequest(String message, String from, String to) {
        this(message, from, to, null);
    }
}