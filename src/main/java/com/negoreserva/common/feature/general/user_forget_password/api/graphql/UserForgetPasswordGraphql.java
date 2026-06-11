package com.negoreserva.common.feature.general.user_forget_password.api.graphql;

import com.negoreserva.common.feature.general.user_forget_password.dto.request.UserForgetPasswordRequest;
import com.negoreserva.common.feature.general.user_forget_password.dto.request.UserForgetResetPasswordRequest;
import com.negoreserva.common.feature.general.user_forget_password.service.UserForgetPasswordFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserForgetPasswordGraphql {
    private final UserForgetPasswordFacade userForgetPasswordFacade;

    @MutationMapping
    public boolean pubSendMessageForgetPassword(@Argument UserForgetPasswordRequest request) {
        userForgetPasswordFacade.sendMessageForgetPassword(request);
        return true;
    }

    @MutationMapping
    public boolean pubResetPassword(@Argument UserForgetResetPasswordRequest request) {
        userForgetPasswordFacade.resetPassword(request);
        return true;
    }
}
