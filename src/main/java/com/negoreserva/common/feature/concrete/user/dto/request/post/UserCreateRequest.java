package com.negoreserva.common.feature.concrete.user.dto.request.post;

import com.negoreserva.common.feature.concrete.user.model.User;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserCreateRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 255, message = "Name too long")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email invalid")
        String email,

        @NotBlank(message = "Phone is required")
        @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Phone invalid")
        String phone,

        @Past(message = "Birthday must be in the past")
        LocalDate birthday
) {

    public User toModel() {
        return User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .birthday(birthday)
                .build();
    }
}
