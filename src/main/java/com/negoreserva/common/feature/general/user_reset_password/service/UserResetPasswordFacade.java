package com.negoreserva.common.feature.general.user_reset_password.service;

import com.negoreserva.common.exception.NotFoundException;
import com.negoreserva.common.feature.concrete.user.exception.notfound.UserUsernameNotFoundException;
import com.negoreserva.common.feature.concrete.user.service.UserService;
import com.negoreserva.common.feature.general.user_forget_password.exception.PasswordsDifferentException;
import com.negoreserva.common.feature.general.user_reset_password.dto.request.UserResetPasswordRequest;
import com.negoreserva.common.feature.general.user_reset_password.exception.WrongPasswordException;
import com.negoreserva.common.util.PasswordEncoderGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserResetPasswordFacade {
    private final UserService userService;

    public boolean resetPassword(Authentication authentication, UserResetPasswordRequest request) {
        if (!authentication.isAuthenticated()) throw new NotFoundException();
        if (authentication instanceof AnonymousAuthenticationToken) throw new NotFoundException();

        var username = extractUsername(authentication);
        var user = userService.findBy(username);

        if (!PasswordEncoderGenerator.matches(request.currentPassword(), user.getPassword())) throw new WrongPasswordException();
        if (!request.newPassword().equals(request.confirmPassword())) throw new PasswordsDifferentException();

        var encodedPassword = PasswordEncoderGenerator.encode(request.newPassword());

        user.setPassword(encodedPassword);
        userService.save(user);

        return true;
    }

    private String extractUsername(Authentication authentication) {
        String username;
        if (authentication.getPrincipal() instanceof Jwt jwt) {
            username = jwt.getSubject();
        } else {
            username = authentication.getName();
        }
        return Optional.ofNullable(username).orElseThrow(UserUsernameNotFoundException::new);
    }
}
