package com.negoreserva.common.feature.general.sms.contract;

import com.negoreserva.common.feature.general.sms.model.SmsOrganizationUpdatePhone;

@FunctionalInterface
public interface ISmsOrganizationUpdatePhoneDispatcher {
    void send(SmsOrganizationUpdatePhone smsOrganizationUpdatePhone);
}
