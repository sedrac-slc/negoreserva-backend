package com.negoreserva.common.feature.general.sms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsUserUpdatePhone {
        private String recept;
        private String otp;
}
