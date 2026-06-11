package com.negoreserva.common.feature.general.login.api.graphql;

import com.negoreserva.common.feature.general.register.dto.response.UserAuthResponse;
import com.negoreserva.common.feature.general.login.dto.request.LoginRequest;
import com.negoreserva.common.feature.general.login.service.LoginFacade;
import com.negoreserva.common.component.TokenFacade;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@RequiredArgsConstructor
public class LoginGraphql {
    private final AuthenticationManager authenticationManager;
    private final TokenFacade tokenFacade;
    private final LoginFacade loginFacade;

    @MutationMapping
    public UserAuthResponse pubLogin(@Argument LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        var tokenResponse = tokenFacade.generateToken(authentication, response);

        return loginFacade.getUser(authentication, tokenResponse);
    }
}
