package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher;

import com.negoreserva.common.feature.general.sms.contract.ISmsOrganizationUpdatePhoneDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.request.OmbalaSmsRequest;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.OmbalaSmsFacade;
import com.negoreserva.common.feature.general.sms.model.SmsOrganizationUpdatePhone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OmbalaOrganizationUpdatePhoneDispatcher implements ISmsOrganizationUpdatePhoneDispatcher {
    @Value("${ombala.api.name}")
    private String from;

    private final OmbalaSmsFacade ombalaSmsFacade;

    @Override
    public void send(SmsOrganizationUpdatePhone smsOrganizationUpdatePhone) {
        log.info("[SMS/Phone] Enviando para: {}", smsOrganizationUpdatePhone.getRecept());
        ombalaSmsFacade.sendMessage(
                new OmbalaSmsRequest(
                        "O seu código de confirmação do contacto da empresa:" + smsOrganizationUpdatePhone.getOtp(),
                        from,
                        smsOrganizationUpdatePhone.getRecept()
                )
        );
    }
}
