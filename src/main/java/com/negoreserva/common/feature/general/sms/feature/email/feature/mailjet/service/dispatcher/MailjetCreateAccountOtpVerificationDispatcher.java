package com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.dispatcher;

import com.negoreserva.common.feature.general.sms.contract.ISmsCreateAccountOtpVerificationDispatcher;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetContact;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetMessage;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.dto.request.MailjetSendRequest;
import com.negoreserva.common.feature.general.sms.feature.email.feature.mailjet.service.MailjetEmailFacade;
import com.negoreserva.common.feature.general.sms.model.SmsCreateAccountOtpVerification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MailjetCreateAccountOtpVerificationDispatcher implements ISmsCreateAccountOtpVerificationDispatcher {
    private final MailjetEmailFacade mailjetEmailService;

    @Value("${mailjet.sender.email}")
    private String senderEmail;

    @Value("${mailjet.sender.name}")
    private String senderName;

    @Override
    public void send(SmsCreateAccountOtpVerification smsCreateAccountOtpVerification) {
        var from = new MailjetContact(senderEmail, senderName);
        var to = List.of(new MailjetContact(smsCreateAccountOtpVerification.getRecept(), smsCreateAccountOtpVerification.getRecept()));
        var message = new MailjetMessage(
                from,
                to,
                "Verificação de conta",
                "O seu código de verificação da conta é: " + smsCreateAccountOtpVerification.getOtp(),
                "<h3> seu código de verificação da conta é: <strong>" + smsCreateAccountOtpVerification.getOtp() + "</strong></h3>"
        );
        mailjetEmailService.sendEmail(new MailjetSendRequest(List.of(message)));
    }
}
