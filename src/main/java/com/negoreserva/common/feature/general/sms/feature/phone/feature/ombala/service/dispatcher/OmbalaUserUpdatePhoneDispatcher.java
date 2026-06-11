package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher;

import com.negoreserva.common.feature.general.sms.contract.ISmsUserUpdatePhoneDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.request.OmbalaSmsRequest;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.OmbalaSmsFacade;
import com.negoreserva.common.feature.general.sms.model.SmsUserUpdatePhone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OmbalaUserUpdatePhoneDispatcher implements ISmsUserUpdatePhoneDispatcher {
    @Value("${ombala.api.name}")
    private String from;

    private final OmbalaSmsFacade ombalaSmsFacade;

    @Override
    public void send(SmsUserUpdatePhone smsUserUpdatePhone) {
        log.info("[SMS/Phone] Enviando para: {}", smsUserUpdatePhone.getRecept());
        ombalaSmsFacade.sendMessage(
                new OmbalaSmsRequest(
                        "O seu código de confirmação do contacto:" + smsUserUpdatePhone.getOtp(),
                        from,
                        smsUserUpdatePhone.getRecept()
                )
        );
    }
}
