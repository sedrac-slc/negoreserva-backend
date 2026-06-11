package com.negoreserva.common.feature.general.sms.service;

import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.dispatcher.MailjetForgetPasswordDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher.OmbalaForgetPasswordDispatcher;
import com.negoreserva.common.feature.general.sms.model.SmsForgetPassword;
import com.negoreserva.common.feature.general.sms.util.SmsInputIdentifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SmsForgetPasswordDispatcher {
    private final OmbalaForgetPasswordDispatcher ombalaForgetPasswordDispatcher;
    private final MailjetForgetPasswordDispatcher mailjetForgetPasswordDispatcher;

    public void dispatch(SmsForgetPassword smsForgetPassword) {
        log.info("[SMS/Forget-password] Disparando para: {}", smsForgetPassword.getRecept());
        if (SmsInputIdentifier.isEmail(smsForgetPassword.getRecept())) {
            mailjetForgetPasswordDispatcher.send(smsForgetPassword);
        } else if (SmsInputIdentifier.isPhone(smsForgetPassword.getRecept())) {
            ombalaForgetPasswordDispatcher.send(smsForgetPassword);
        } else {
            throw new IllegalArgumentException("Input inválido — não é email nem telefone: " + smsForgetPassword.getRecept());
        }
    }
}
