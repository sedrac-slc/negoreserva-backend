package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.dispatcher;

import com.negoreserva.common.feature.general.sms.contract.ISmsUserUpdateEmailDispatcher;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetContact;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetMessage;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetSendRequest;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.MailjetEmailFacade;
import com.negoreserva.common.feature.general.sms.model.SmsUserUpdateEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MailjetUserUpdateEmailDispatcher implements ISmsUserUpdateEmailDispatcher {
    private final MailjetEmailFacade mailjetEmailService;

    @Value("${mailjet.sender.email}")
    private String senderEmail;

    @Value("${mailjet.sender.name}")
    private String senderName;

    @Override
    public void send(SmsUserUpdateEmail smsUserUpdateEmail) {
        var from = new MailjetContact(senderEmail, senderName);
        var to = List.of(new MailjetContact(smsUserUpdateEmail.getRecept(), smsUserUpdateEmail.getRecept()));
        var message = new MailjetMessage(
                from,
                to,
                "Alteração de email do usuário",
                "O seu código de confirmação: " + smsUserUpdateEmail.getOtp(),
                "<h3>O seu código de confirmação: <strong>" + smsUserUpdateEmail.getOtp() + "</strong></h3>"
        );
        mailjetEmailService.sendEmail(new MailjetSendRequest(List.of(message)));
    }
}
