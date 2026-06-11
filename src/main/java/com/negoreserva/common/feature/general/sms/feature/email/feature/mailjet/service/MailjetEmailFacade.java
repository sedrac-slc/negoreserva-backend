package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service;

import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetSendRequest;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.response.MailjetSendResponse;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.exception.MailjetApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class MailjetEmailFacade {
    private final RestClient mailjetRestClient;

    public MailjetSendResponse sendEmail(MailjetSendRequest request) {
        return mailjetRestClient.post()
                .uri("/send")
                .body(request)
                .retrieve()
                .onStatus(status -> status.value() != 200 && status.value() != 201, (req, res) -> {
                    throw new MailjetApiException("Mailjet API retornou status inesperado: " + res.getStatusCode());
                }).body(MailjetSendResponse.class);
    }
}
