package com.negoreserva.common.feature.general.sms.contract;

import com.negoreserva.common.feature.general.sms.model.SmsUserUpdateEmail;

@FunctionalInterface
public interface ISmsUserUpdateEmailDispatcher {
    void send(SmsUserUpdateEmail smsUserUpdateEmail);
}
