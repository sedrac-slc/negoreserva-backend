package com.negoreserva.common.feature.general.sms.service;

import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.dispatcher.MailjetOrganizationUpdateEmailDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher.OmbalaOrganizationUpdateEmailDispatcher;
import com.negoreserva.common.feature.general.sms.model.SmsOrganizationUpdateEmail;
import com.negoreserva.common.feature.general.sms.util.SmsInputIdentifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SmsOrganizationUpdateEmailDispatcher {
    private final OmbalaOrganizationUpdateEmailDispatcher ombalaForgetPasswordDispatcher;
    private final MailjetOrganizationUpdateEmailDispatcher mailjetForgetPasswordDispatcher;

    public void dispatch(SmsOrganizationUpdateEmail smsOrganizationUpdateEmail) {
        log.info("[SMS/Organization-update-email] Disparando para: {}", smsOrganizationUpdateEmail.getRecept());
        if (SmsInputIdentifier.isEmail(smsOrganizationUpdateEmail.getRecept())) {
            mailjetForgetPasswordDispatcher.send(smsOrganizationUpdateEmail);
        } else if (SmsInputIdentifier.isPhone(smsOrganizationUpdateEmail.getRecept())) {
            ombalaForgetPasswordDispatcher.send(smsOrganizationUpdateEmail);
        } else {
            throw new IllegalArgumentException("Input inválido — não é email nem telefone: " + smsOrganizationUpdateEmail.getRecept());
        }
    }
}
