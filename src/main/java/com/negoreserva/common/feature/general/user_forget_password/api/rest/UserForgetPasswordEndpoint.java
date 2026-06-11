package com.negoreserva.common.feature.general.user_forget_password.api.rest;

import com.negoreserva.common.feature.general.user_forget_password.dto.request.UserForgetPasswordRequest;
import com.negoreserva.common.feature.general.user_forget_password.dto.request.UserForgetResetPasswordRequest;
import com.negoreserva.common.feature.general.user_forget_password.service.UserForgetPasswordFacade;
import com.negoreserva.common.feature.general.user_forget_password.util.UserForgetPasswordRouteNamed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(UserForgetPasswordRouteNamed.PATH)
public class UserForgetPasswordEndpoint {
    private final UserForgetPasswordFacade userForgetPasswordFacade;

    @PostMapping
    public ResponseEntity<Boolean> sendMessageForgetPassword(@RequestBody @Valid UserForgetPasswordRequest request) {
         userForgetPasswordFacade.sendMessageForgetPassword(request);
         return ResponseEntity.ok(true);
    }

    @PutMapping
    public ResponseEntity<Boolean> resetPassword(@Argument UserForgetResetPasswordRequest request) {
        userForgetPasswordFacade.resetPassword(request);
        return ResponseEntity.ok(true);
    }
}
