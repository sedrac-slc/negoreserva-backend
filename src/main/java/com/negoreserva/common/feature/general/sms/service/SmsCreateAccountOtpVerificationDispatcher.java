package com.negoreserva.common.feature.general.sms.service;

import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.dispatcher.MailjetCreateAccountOtpVerificationDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher.OmbalaCreateAccountOtpVerificationDispatcher;
import com.negoreserva.common.feature.general.sms.model.SmsCreateAccountOtpVerification;
import com.negoreserva.common.feature.general.sms.util.SmsInputIdentifier;
import com.negoreserva.common.variable.AsyncBeanVariable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SmsCreateAccountOtpVerificationDispatcher {
    private final OmbalaCreateAccountOtpVerificationDispatcher ombalaCreateAccountOtpVerificationDispatcher;
    private final MailjetCreateAccountOtpVerificationDispatcher mailjetCreateAccountOtpVerificationDispatcher;

    @Async(AsyncBeanVariable.CREATE_ACCOUNT_OTP_VERIFICATION)
    public void dispatch(SmsCreateAccountOtpVerification smsCreateAccountOtpVerification) {
        log.info("[SMS/Cretae-account-otp-verification] Disparando para: {}", smsCreateAccountOtpVerification.getRecept());

        if (SmsInputIdentifier.isEmail(smsCreateAccountOtpVerification.getRecept())) {
            mailjetCreateAccountOtpVerificationDispatcher.send(smsCreateAccountOtpVerification);
        } else if (SmsInputIdentifier.isPhone(smsCreateAccountOtpVerification.getRecept())) {
            ombalaCreateAccountOtpVerificationDispatcher.send(smsCreateAccountOtpVerification);
        } else {
            throw new IllegalArgumentException("Input inválido — não é email nem telefone: " + smsCreateAccountOtpVerification.getRecept());
        }
    }
}
