package com.negoreserva.common.feature.general.register.api.rest;

import com.negoreserva.common.feature.general.register.dto.request.ConfirmUserOtpVerificationRequest;
import com.negoreserva.common.feature.general.register.dto.request.CreateAccountOrganizationRequest;
import com.negoreserva.common.feature.general.register.dto.request.ResendUserOtpVerificationRequest;
import com.negoreserva.common.feature.general.register.dto.request.CreateAccountClientRequest;
import com.negoreserva.common.feature.general.register.service.RegisterOrganizationFacade;
import com.negoreserva.common.feature.general.register.dto.response.CreateAccountResponse;
import com.negoreserva.common.feature.general.register.dto.response.UserAuthResponse;
import com.negoreserva.common.feature.general.register.service.RegisterClientFacade;
import com.negoreserva.common.feature.general.register.util.RegisterRouteNamed;
import com.negoreserva.common.feature.general.register.service.RegisterFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping(RegisterRouteNamed.PATH)
@Tag(name = "Public - Register", description = "Endpoints for register account")
public class RegisterEndpoint {
    private final RegisterOrganizationFacade registerOrganizationFacade;
    private final RegisterClientFacade registerClientFacade;
    private final RegisterFacade registerFacade;

    @PostMapping(RegisterRouteNamed.ORGANIZATION)
    @Operation(summary = "Create account for organization")
    public ResponseEntity<CreateAccountResponse> createAccountOrganization(@RequestBody @Valid CreateAccountOrganizationRequest request, HttpServletResponse response) {
        var result = registerOrganizationFacade.createAccount(request, response);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping(RegisterRouteNamed.CLIENT)
    @Operation(summary = "Create account for client")
    public ResponseEntity<CreateAccountResponse> createAccountClient(@RequestBody @Valid CreateAccountClientRequest request, HttpServletResponse response) {
        var result = registerClientFacade.createAccount(request, response);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping(RegisterRouteNamed.RESEND)
    @Operation(summary = "Resend Otp")
    public ResponseEntity<CreateAccountResponse> resend(@RequestBody @Valid ResendUserOtpVerificationRequest request) {
        var response = registerFacade.resendOtp(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(RegisterRouteNamed.CONFIRM)
    @Operation(summary = "Confirm Otp")
    public UserAuthResponse confirmOtp(@RequestBody @Valid ConfirmUserOtpVerificationRequest request) {
        return registerFacade.confirmOtp(request);
    }
}
