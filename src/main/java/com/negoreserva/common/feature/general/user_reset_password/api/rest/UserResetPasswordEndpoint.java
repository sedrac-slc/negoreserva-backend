package com.negoreserva.common.feature.general.user_reset_password.api.rest;

import com.negoreserva.common.feature.general.user_reset_password.dto.request.UserResetPasswordRequest;
import com.negoreserva.common.feature.general.user_reset_password.service.UserResetPasswordFacade;
import com.negoreserva.common.feature.general.user_reset_password.util.UserResetPasswordRouteNamed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(UserResetPasswordRouteNamed.PATH)
public class UserResetPasswordEndpoint {
    private final UserResetPasswordFacade userResetPasswordFacade;

    @PutMapping
    @Operation(summary = "Reset password for authenticated user", security = @SecurityRequirement(name = "basicAuth"))
    public ResponseEntity<Boolean> resetPassword(Authentication authentication, @RequestBody @Valid UserResetPasswordRequest request) {
        return ResponseEntity.ok(userResetPasswordFacade.resetPassword(authentication, request));
    }
}
