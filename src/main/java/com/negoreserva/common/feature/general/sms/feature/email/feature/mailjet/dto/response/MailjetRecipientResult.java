package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MailjetRecipientResult(
        @JsonProperty("Email")       String email,
        @JsonProperty("MessageUUID") String messageUUID,
        @JsonProperty("MessageID")   Long messageID,
        @JsonProperty("MessageHref") String messageHref
) {}
