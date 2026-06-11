package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MailjetSendRequest(
        @JsonProperty("Messages") List<MailjetMessage> messages
) {}
