package com.negoreserva.common.feature.core.util;

import org.jspecify.annotations.NonNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.*;

import java.util.List;

public final class ProblemDetailHelpers {


    public static ResponseEntity<ProblemDetail> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("Data Integrity Violation");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
    }

    public static ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, "Validation failed for one or more fields.");
        problemDetail.setTitle("Invalid Request Parameters");
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        problemDetail.setProperty("errors", errors);
        return ResponseEntity.status(status).body(problemDetail);
    }

    public static ResponseEntity<ProblemDetail> notFound(String title, String detail) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle(title);
        problem.setDetail(detail);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    public static ResponseEntity<ProblemDetail> notFound(String detail) {
        return notFound("Not found", detail);
    }

    public static ResponseEntity<ProblemDetail> conflict(String title, String detail) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle(title);
        problem.setDetail(detail);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }
}
