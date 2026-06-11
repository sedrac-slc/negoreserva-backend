package com.negoreserva.common.feature.general.user_reset_password.api.graphql;

import com.negoreserva.common.feature.general.user_reset_password.dto.request.UserResetPasswordRequest;
import com.negoreserva.common.feature.general.user_reset_password.service.UserResetPasswordFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserResetPasswordGraphql {
    private final UserResetPasswordFacade userResetPasswordFacade;

    @MutationMapping
    public boolean userResetPassword(@Argument UserResetPasswordRequest request, Authentication authentication) {
        return userResetPasswordFacade.resetPassword(authentication, request);
    }
}
