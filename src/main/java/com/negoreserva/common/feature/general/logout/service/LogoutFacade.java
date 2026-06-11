package com.negoreserva.common.feature.general.logout.service;

import com.negoreserva.common.component.TokenFacade;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutFacade {
    private final TokenFacade tokenFacade;

    public boolean logout(Authentication authentication, HttpServletResponse response) {
        var isAuthenticated = authentication.isAuthenticated();
        if (isAuthenticated) tokenFacade.clearTokenCookie(response);
        return isAuthenticated;
    }
}
