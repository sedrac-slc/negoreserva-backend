package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.config;


import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.exception.OmbalaApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.negoreserva.common.feature.sms.feature.phone.feature.ombala")
public class OmbalaRestErrorsHandler {

    @ExceptionHandler(OmbalaApiException.class)
    public ProblemDetail handleOmbalaApiException(OmbalaApiException ex) {
        var problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_GATEWAY,
                "Falha ao enviar SMS via Ombala. Tente novamente."
        );
        problem.setTitle("Erro no serviço de mensagens");
        return problem;
    }
}