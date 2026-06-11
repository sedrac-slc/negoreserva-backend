package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Base64;

@Configuration
public class MailjetRestClientConfig {
    @Value("${mailjet.api.base-url}")
    private String baseUrl;

    @Value("${mailjet.api.public-key}")
    private String publicKey;

    @Value("${mailjet.api.private-key}")
    private String privateKey;

    @Bean
    public RestClient mailjetRestClient() {
        var credentials = Base64.getEncoder()
                .encodeToString((publicKey + ":" + privateKey).getBytes());

        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + credentials)
                .build();
    }
}
