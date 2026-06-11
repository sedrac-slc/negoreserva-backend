package com.negoreserva.internal.admin.util;

import com.negoreserva.common.feature.core.util.ProblemDetailHelpers;
import org.jspecify.annotations.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

public final class AdminProblemDetailHelpers {

    public static ResponseEntity<ProblemDetail> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("Data Integrity Violation");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
    }

    public static ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        return ProblemDetailHelpers.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    public static ResponseEntity<ProblemDetail> notFound(String title, String detail) {
        return ProblemDetailHelpers.notFound(title, detail);
    }

    public static ResponseEntity<ProblemDetail> conflict(String title, String detail) {
        return ProblemDetailHelpers.conflict(title, detail);
    }
}