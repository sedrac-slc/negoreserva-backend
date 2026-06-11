package com.negoreserva.common.feature.concrete.user.util;

public final class UserValidators {
    public static boolean isEmail(String email) {return email.contains("@");}
    public static boolean isUsername(String username) {return username.contains("#");}
    public static boolean isDigit(String digit) {return digit.matches("\\d+");}
    public static boolean isPhone(String phone) {return phone.matches("^[+\\d][\\d\\s\\-().]{6,}$");}
}
