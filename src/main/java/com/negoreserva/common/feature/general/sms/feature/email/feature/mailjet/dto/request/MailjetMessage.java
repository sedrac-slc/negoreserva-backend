package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MailjetMessage(
        @JsonProperty("From")      MailjetContact from,
        @JsonProperty("To")        List<MailjetContact> to,
        @JsonProperty("Subject")   String subject,
        @JsonProperty("TextPart")  String textPart,
        @JsonProperty("HTMLPart")  String htmlPart
) {}