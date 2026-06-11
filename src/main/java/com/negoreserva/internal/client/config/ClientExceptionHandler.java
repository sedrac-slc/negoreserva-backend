package com.negoreserva.internal.client.config;


import com.negoreserva.common.feature.concrete.user.exception.notfound.UserEmailNotFoundException;
import com.negoreserva.common.feature.concrete.user.exception.notfound.UserNotFoundException;
import com.negoreserva.common.feature.concrete.user.exception.notfound.UserPhoneNotFoundException;
import com.negoreserva.common.feature.concrete.user.exception.unique.UserEmailAlreadyExistsException;
import com.negoreserva.common.feature.concrete.user.exception.unique.UserPhoneAlreadyExistsException;
import com.negoreserva.internal.client.util.ClientProblemDetailHelpers;
import org.jspecify.annotations.NonNull;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.*;

@RestControllerAdvice(basePackages = "com.negoreserva.internal.client")
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        return ClientProblemDetailHelpers.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<ProblemDetail> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return ClientProblemDetailHelpers.handleDataIntegrityViolation(ex);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleUserNotFoundException(UserNotFoundException ex) {
        return ClientProblemDetailHelpers.notFound("User not found", ex.getMessage());
    }

    @ExceptionHandler(UserEmailNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleUserEmailNotFoundException(UserEmailNotFoundException ex) {
        return ClientProblemDetailHelpers.notFound("User not found by email", ex.getMessage());
    }

    @ExceptionHandler(UserPhoneNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleUserPhoneNotFoundException(UserPhoneNotFoundException ex) {
        return ClientProblemDetailHelpers.notFound("User not found by phone", ex.getMessage());
    }

    @ExceptionHandler(UserEmailAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleUserEmailAlreadyExistsException(UserEmailAlreadyExistsException ex) {
        return ClientProblemDetailHelpers.conflict("Email already exists", ex.getMessage());
    }

    @ExceptionHandler(UserPhoneAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleUserPhoneAlreadyExistsException(UserPhoneAlreadyExistsException ex) {
        return ClientProblemDetailHelpers.conflict("Phone already exists", ex.getMessage());
    }


}