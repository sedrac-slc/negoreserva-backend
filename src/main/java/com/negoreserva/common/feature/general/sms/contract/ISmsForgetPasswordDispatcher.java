package com.negoreserva.common.feature.general.sms.contract;

import com.negoreserva.common.feature.general.sms.model.SmsForgetPassword;

@FunctionalInterface
public interface ISmsForgetPasswordDispatcher {
    void send(SmsForgetPassword smsForgetPassword);
}
