package com.negoreserva.common.feature.general.login.service;

import com.negoreserva.common.dto.TokenResponse;
import com.negoreserva.common.feature.general.register.dto.response.UserAuthResponse;
import com.negoreserva.common.feature.concrete.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginFacade {
    private final UserService userService;

    public UserAuthResponse getUser(Authentication authentication, TokenResponse tokenResponse) {
        var user = userService.findBy(authentication.getName());
        return new UserAuthResponse(
                tokenResponse.token(),
                user.getName(),
                user.getEmail(),
                user.getType(),
                user.getStatus(),
                user.getLogo(),
                tokenResponse.expiredAt()
        );
    }

}
