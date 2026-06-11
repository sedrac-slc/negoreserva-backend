package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MailjetContact(
        @JsonProperty("Email") String email,
        @JsonProperty("Name")  String name
) {}
