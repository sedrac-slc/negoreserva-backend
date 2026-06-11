package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class SmsScheduleFormatter {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private SmsScheduleFormatter() {}

    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static String from(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }
}