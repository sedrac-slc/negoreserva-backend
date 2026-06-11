package com.negoreserva.common.feature.general.logout.api.rest;

import com.negoreserva.common.feature.general.logout.service.LogoutFacade;
import com.negoreserva.common.feature.general.logout.util.LogoutRouteNamed;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;

@RestController
@RequiredArgsConstructor
@RequestMapping(LogoutRouteNamed.PATH)
public class LogoutEndpoint {
    private final LogoutFacade loginFacade;

    @PostMapping
    @Operation(summary = "Logout in application", security = @SecurityRequirement(name = "basicAuth"))
    public boolean logout(Authentication authentication, HttpServletResponse response) {
        return loginFacade.logout(authentication, response);
    }

}
