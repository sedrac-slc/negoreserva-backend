package com.negoreserva.internal.admin.feature.user.api.rest;

import com.negoreserva.common.feature.concrete.user.dto.queryparam.UserFilterQueryParam;
import com.negoreserva.common.feature.concrete.user.dto.request.post.UserCreateRequest;
import com.negoreserva.common.feature.concrete.user.dto.request.put.UserUpdateRequest;
import com.negoreserva.common.feature.concrete.user.dto.response.UserPaginate;
import com.negoreserva.common.feature.concrete.user.dto.response.UserResponse;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.internal.admin.feature.user.service.AdminUserService;
import com.negoreserva.internal.admin.feature.user.util.UserRouteNamed;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(UserRouteNamed.PATH)
public class AdminUserController {

    private final AdminUserService service;

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<UserPaginate> findAll(@ParameterObject Pageable page) {
        return ResponseEntity.ok(service.paginate(page));
    }

    @GetMapping("/filter")
    @Operation(summary = "Get users by filter")
    public ResponseEntity<UserPaginate> findByFilter(@ParameterObject @ModelAttribute UserFilterQueryParam filter) {
        return ResponseEntity.ok(service.paginate(filter));
    }

    @GetMapping(UserRouteNamed.FIND_BY_EMAIL)
    @Operation(summary = "Get user by email")
    public ResponseEntity<UserResponse> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findByEmail(email).toResponse());
    }

    @GetMapping(UserRouteNamed.FIND_BY_PHONE)
    @Operation(summary = "Get user by phone")
    public ResponseEntity<UserResponse> findByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(service.findByPhone(phone).toResponse());
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Get user by uuid")
    public ResponseEntity<UserResponse> findByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid).toResponse());
    }

    @PostMapping
    @Operation(summary = "Create user")
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserCreateRequest userDto) {
        User user = service.save(userDto.toModel());
        return new ResponseEntity<>(user.toResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @Operation(summary = "Update user")
    public ResponseEntity<UserResponse> update(@PathVariable UUID uuid, @RequestBody @Valid UserUpdateRequest userDto) {
        User user = service.update(uuid, userDto.toModel());
        return new ResponseEntity<>(user.toResponse(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Delete user by uuid")
    public ResponseEntity<Void> deleteByUuid(@PathVariable UUID uuid) {
        service.deleteByUuid(uuid);
        return ResponseEntity.noContent().build();
    }
}