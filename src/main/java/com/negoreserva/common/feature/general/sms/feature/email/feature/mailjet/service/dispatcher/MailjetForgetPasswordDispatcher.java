package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.dispatcher;

import com.negoreserva.common.feature.general.sms.contract.ISmsForgetPasswordDispatcher;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetContact;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetMessage;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetSendRequest;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.MailjetEmailFacade;
import com.negoreserva.common.feature.general.sms.model.SmsForgetPassword;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MailjetForgetPasswordDispatcher implements ISmsForgetPasswordDispatcher {

    private final MailjetEmailFacade mailjetEmailService;

    @Value("${mailjet.sender.email}")
    private String senderEmail;

    @Value("${mailjet.sender.name}")
    private String senderName;

    @Override
    public void send(SmsForgetPassword smsForgetPassword) {
        log.info("[SMS/Email] Enviando para: {}", smsForgetPassword.getRecept());
        var from    = new MailjetContact(senderEmail, senderName);
        var to      = List.of(new MailjetContact(smsForgetPassword.getRecept(), smsForgetPassword.getRecept()));
        var message = new MailjetMessage(
                from,
                to,
                "Recuperação de senha",
                "O seu código de recuperação é: " + smsForgetPassword.getOtp(),
                "<h3>O seu código de recuperação é: <strong>" + smsForgetPassword.getOtp() + "</strong></h3>"
        );
        mailjetEmailService.sendEmail(new MailjetSendRequest(List.of(message)));
    }
}
