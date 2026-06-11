package com.negoreserva.common.feature.concrete.user.api.rest;

import com.negoreserva.common.feature.concrete.user.dto.request.post.UserResetPasswordCurrentRequest;
import com.negoreserva.common.feature.concrete.user.dto.response.UserResponse;
import com.negoreserva.common.feature.concrete.user.request.UserEditProfileRequest;
import com.negoreserva.common.feature.concrete.user.service.UserService;
import com.negoreserva.common.feature.concrete.user.util.UserRouteNamed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Tag(name = "Auth - User")
@RequestMapping(UserRouteNamed.PATH)
public class UserController {
    private final UserService userService;

    @PutMapping
    @Operation(summary = "Update user")
    public ResponseEntity<UserResponse> updateUser(@ParameterObject UserEditProfileRequest request, Authentication authentication
    ) {
        return ResponseEntity.ok(userService.update(request, authentication).toResponse());
    }

    @PutMapping(value = UserRouteNamed.UPLOAD_LOGO, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Edit logo of user")
    public ResponseEntity<UserResponse> updateLogoUser(
            @RequestPart("file") MultipartFile file,
            Authentication authentication
    ) {
        return ResponseEntity.ok(userService.updateLogoUser(file, authentication).toResponse());
    }

    @PutMapping(value = UserRouteNamed.UPDATE_PASSWORD)
    @Operation(summary = "Edit password of user")
    public ResponseEntity<UserResponse> userRestPassword(@RequestBody @Valid UserResetPasswordCurrentRequest request, Authentication authentication) {
        return  ResponseEntity.ok(userService.update(request, authentication).toResponse());
    }
}
