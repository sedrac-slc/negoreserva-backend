package com.negoreserva.common.feature.general.logout.api.graphql;

import com.negoreserva.common.feature.general.logout.service.LogoutFacade;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@RequiredArgsConstructor
public class LogoutGraphql {
    private final LogoutFacade loginFacade;

    @MutationMapping
    public boolean pubLogout(Authentication authentication) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        return loginFacade.logout(authentication, response);
    }
}
