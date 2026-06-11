package com.negoreserva.internal.admin.config;

import com.negoreserva.internal.admin.util.AdminProblemDetailHelpers;
import org.jspecify.annotations.NonNull;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.*;

@RestControllerAdvice(basePackages = "com.negoreserva.internal.admin")
public class AdminExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        return AdminProblemDetailHelpers.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<ProblemDetail> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return AdminProblemDetailHelpers.handleDataIntegrityViolation(ex);
    }

}