package com.negoreserva.common.feature.general.sms.contract;

import com.negoreserva.common.feature.general.sms.model.SmsUserUpdatePhone;

@FunctionalInterface
public interface ISmsUserUpdatePhoneDispatcher {
    void send(SmsUserUpdatePhone smsUserUpdatePhone);
}
