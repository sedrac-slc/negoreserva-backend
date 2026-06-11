package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher;

import com.negoreserva.common.feature.general.sms.contract.ISmsOrganizationUpdateEmailDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.request.OmbalaSmsRequest;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.OmbalaSmsFacade;
import com.negoreserva.common.feature.general.sms.model.SmsOrganizationUpdateEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OmbalaOrganizationUpdateEmailDispatcher implements ISmsOrganizationUpdateEmailDispatcher {
    @Value("${ombala.api.name}")
    private String from;

    private final OmbalaSmsFacade ombalaSmsFacade;

    @Override
    public void send(SmsOrganizationUpdateEmail smsOrganizationUpdateEmail) {
        log.info("[SMS/Phone] Enviando para: {}", smsOrganizationUpdateEmail.getRecept());
        ombalaSmsFacade.sendMessage(
                new OmbalaSmsRequest(
                        "O seu código de confirmação do email da empresa:" + smsOrganizationUpdateEmail.getOtp(),
                        from,
                        smsOrganizationUpdateEmail.getRecept()
                )
        );
    }
}
