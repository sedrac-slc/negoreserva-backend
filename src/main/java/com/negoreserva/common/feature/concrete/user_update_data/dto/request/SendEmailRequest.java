package com.negoreserva.common.feature.concrete.user_update_data.dto.request;

import jakarta.validation.constraints.Email;

public record SendEmailRequest(@Email String input) { }
