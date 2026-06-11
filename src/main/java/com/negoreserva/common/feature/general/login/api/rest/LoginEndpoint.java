package com.negoreserva.common.feature.general.login.api.rest;

import com.negoreserva.common.feature.general.register.dto.response.UserAuthResponse;
import com.negoreserva.common.feature.general.login.util.LoginRouteNamed;
import com.negoreserva.common.feature.general.login.service.LoginFacade;
import com.negoreserva.common.component.TokenFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;

@RestController
@RequiredArgsConstructor
@RequestMapping(LoginRouteNamed.PATH)
public class LoginEndpoint {
    private final TokenFacade tokenFacade;
    private final LoginFacade loginFacade;

    @PostMapping(LoginRouteNamed.TOKEN)
    @Operation(
            summary = "Token generator token JWT",
            security = @SecurityRequirement(name = "basicAuth")
    )
    public UserAuthResponse token(Authentication authentication, HttpServletResponse response) {
        var token = tokenFacade.generateToken(authentication, response);
        return loginFacade.getUser(authentication, token);
    }

}
