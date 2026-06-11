package com.negoreserva.common.feature.general.register.dto.request;

import com.negoreserva.common.feature.general.register.util.UsernameGenerator;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.util.PasswordEncoderGenerator;
import com.negoreserva.common.util.RegexValidators;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request for client account creation")
public record CreateAccountClientRequest(

        @Schema(description = "Client full name", example = "John Doe", maxLength = 100)
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name too long")
        String name,

        @Schema(description = "Client email address", example = "john.doe@email.com", maxLength = 100)
        @NotBlank(message = "Email is required")
        @Size(max = 100, message = "Email too long")
        String email,

        @Schema(description = "Client phone number", example = "+244923000000", maxLength = 15)
        @NotBlank(message = "Phone is required")
        @Pattern(regexp = RegexValidators.PATTERN_PHONE, message = "Phone invalid")
        @Size(max = 15)
        String phone,

        @Schema(description = "User account password", example = "Password@123", maxLength = 100)
        @NotBlank(message = "Password is required")
        @Size(max = 100, message = "Password too long")
        String password,

        @Schema(description = "Password confirmation", example = "Password@123", maxLength = 100)
        @NotBlank(message = "Confirm password is required")
        @Size(max = 100, message = "Confirm password too long")
        String confirm

) {

        public User toUserModel() {
                var username = UsernameGenerator.generate(name);
                var encodedPassword = PasswordEncoderGenerator.encode(password);

                return User.builder()
                        .username(username)
                        .name(name)
                        .email(email)
                        .phone(phone)
                        .password(encodedPassword)
                        .build();
        }

}