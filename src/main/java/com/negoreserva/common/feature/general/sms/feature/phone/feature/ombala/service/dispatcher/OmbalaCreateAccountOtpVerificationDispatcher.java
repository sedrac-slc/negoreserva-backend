package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.dispatcher;

import com.negoreserva.common.feature.general.sms.contract.ISmsCreateAccountOtpVerificationDispatcher;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.dto.request.OmbalaSmsRequest;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.service.OmbalaSmsFacade;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.util.SmsScheduleFormatter;
import com.negoreserva.common.feature.general.sms.model.SmsCreateAccountOtpVerification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OmbalaCreateAccountOtpVerificationDispatcher implements ISmsCreateAccountOtpVerificationDispatcher {

    private final OmbalaSmsFacade ombalaSmsFacade;

    @Override
    public void send(SmsCreateAccountOtpVerification smsForgetPassword) {
        ombalaSmsFacade.sendMessage(
                new OmbalaSmsRequest(
                        "O seu código de verificação é: " + smsForgetPassword.getOtp(),
                        "MINHALOJA",
                        smsForgetPassword.getRecept(),
                        SmsScheduleFormatter.now()
                )
        );
    }
}
