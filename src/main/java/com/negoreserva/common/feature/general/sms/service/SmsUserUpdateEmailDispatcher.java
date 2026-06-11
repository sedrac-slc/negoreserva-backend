package com.negoreserva.common.feature.general.sms.service;

import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.dispatcher.MailjetUserUpdateEmailDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher.OmbalaUserUpdateEmailDispatcher;
import com.negoreserva.common.feature.general.sms.model.SmsUserUpdateEmail;
import com.negoreserva.common.feature.general.sms.util.SmsInputIdentifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SmsUserUpdateEmailDispatcher {
    private final OmbalaUserUpdateEmailDispatcher ombalaForgetPasswordDispatcher;
    private final MailjetUserUpdateEmailDispatcher mailjetForgetPasswordDispatcher;

    public void dispatch(SmsUserUpdateEmail smsUserUpdateEmail) {
        log.info("[SMS/User-update-email] Disparando para: {}", smsUserUpdateEmail.getRecept());
        if (SmsInputIdentifier.isEmail(smsUserUpdateEmail.getRecept())) {
            mailjetForgetPasswordDispatcher.send(smsUserUpdateEmail);
        } else if (SmsInputIdentifier.isPhone(smsUserUpdateEmail.getRecept())) {
            ombalaForgetPasswordDispatcher.send(smsUserUpdateEmail);
        } else {
            throw new IllegalArgumentException("Input inválido — não é email nem telefone: " + smsUserUpdateEmail.getRecept());
        }
    }
}
