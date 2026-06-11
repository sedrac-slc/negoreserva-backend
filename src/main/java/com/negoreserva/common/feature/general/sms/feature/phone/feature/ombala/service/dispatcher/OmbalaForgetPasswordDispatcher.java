package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher;

import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.request.OmbalaSmsRequest;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.OmbalaSmsFacade;
import com.negoreserva.common.feature.general.sms.contract.ISmsForgetPasswordDispatcher;
import com.negoreserva.common.feature.general.sms.model.SmsForgetPassword;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OmbalaForgetPasswordDispatcher implements ISmsForgetPasswordDispatcher {
    @Value("${ombala.api.name}")
    private String from;

    private final OmbalaSmsFacade ombalaSmsFacade;

    @Override
    public void send(SmsForgetPassword smsForgetPassword) {
        log.info("[SMS/Phone] Enviando para: {}", smsForgetPassword.getRecept());
        ombalaSmsFacade.sendMessage(
                new OmbalaSmsRequest(
                        "O seu código de recuperação é: " + smsForgetPassword.getOtp(),
                        from,
                        smsForgetPassword.getRecept()
                )
        );
    }
}
