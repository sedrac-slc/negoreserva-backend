package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service;

import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.request.OmbalaSmsRequest;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.response.OmbalaSmsResponse;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.exception.OmbalaApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class OmbalaSmsFacade {

    private final RestClient ombalaRestClient;

    public OmbalaSmsResponse sendMessage(OmbalaSmsRequest request) {
        return ombalaRestClient.post()
                .uri("/messages")
                .body(request)
                .retrieve()
                .onStatus(status -> status.value() != 200 && status.value() != 201, (req, res) -> {
                    String responseBody = new String(res.getBody().readAllBytes(), StandardCharsets.UTF_8);
                    log.error("[Ombala] Status: {} | Body: {}", res.getStatusCode(), responseBody);
                    throw new OmbalaApiException("Ombala API retornou status inesperado: " + res.getStatusCode());
                })
                .body(OmbalaSmsResponse.class);
    }
}