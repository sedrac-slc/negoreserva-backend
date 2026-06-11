package com.negoreserva.common.feature.general.sms.contract;

import com.negoreserva.common.feature.general.sms.model.SmsCreateAccountOtpVerification;

@FunctionalInterface
public interface ISmsCreateAccountOtpVerificationDispatcher {
    void send(SmsCreateAccountOtpVerification smsCreateAccountOtpVerification);
}
