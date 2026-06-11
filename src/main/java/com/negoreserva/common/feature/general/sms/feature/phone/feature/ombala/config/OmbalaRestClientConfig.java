package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.config;

import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.exception.OmbalaApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class OmbalaRestClientConfig {
    @Value("${ombala.api.base-url}")
    private String baseUrl;

    @Value("${ombala.api.token}")
    private String apiToken;

    @Bean
    public RestClient ombalaRestClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiToken)
                .defaultStatusHandler(HttpStatusCode::isError, (request, response) -> {
                    throw new OmbalaApiException("Erro na API Ombala: " + response.getStatusCode());
                }).build();
    }
}
