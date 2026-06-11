package com.negoreserva.common.feature.general.sms.contract;

import com.negoreserva.common.feature.general.sms.model.SmsOrganizationUpdateEmail;

@FunctionalInterface
public interface ISmsOrganizationUpdateEmailDispatcher {
    void send(SmsOrganizationUpdateEmail smsOrganizationUpdateEmail);
}
