package com.negoreserva.common.util;

import com.negoreserva.common.feature.concrete.category.exception.unique.CategoryNameAlreadyExistsException;
import com.negoreserva.common.feature.concrete.organization.exception.unique.OrganizationEmailAlreadyExistsException;
import com.negoreserva.common.feature.concrete.organization.exception.unique.OrganizationNameAlreadyExistsException;
import com.negoreserva.common.feature.concrete.organization.exception.unique.OrganizationPhoneAlreadyExistsException;
import com.negoreserva.common.feature.concrete.user.exception.unique.UserEmailAlreadyExistsException;
import com.negoreserva.common.feature.concrete.user.exception.unique.UserPhoneAlreadyExistsException;
import com.negoreserva.common.feature.concrete.user.exception.unique.UserUsernameAlreadyExistsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public final class ConstraintUniqueList {

    private static final Map<String, Supplier<RuntimeException>> ITEMS = Map.of(
            ConstraintUniqueKey.USER_USERNAME, UserUsernameAlreadyExistsException::new,
            ConstraintUniqueKey.USER_EMAIL, UserEmailAlreadyExistsException::new,
            ConstraintUniqueKey.USER_PHONE, UserPhoneAlreadyExistsException::new,

            ConstraintUniqueKey.ORGANIZATION_NAME, OrganizationNameAlreadyExistsException::new,
            ConstraintUniqueKey.ORGANIZATION_EMAIL, OrganizationEmailAlreadyExistsException::new,
            ConstraintUniqueKey.ORGANIZATION_PHONE, OrganizationPhoneAlreadyExistsException::new,

            ConstraintUniqueKey.CATEGORY_NAME, CategoryNameAlreadyExistsException::new
    );

    public static Optional<ProblemDetail> of(DataIntegrityViolationException exception) {
        String message = exception.getMessage();
        if (message == null) return Optional.empty();

        return ITEMS.entrySet().stream()
                .filter(entry -> message.contains(entry.getKey()))
                .map(entry -> {
                    var ex = entry.getValue().get();

                    ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
                    problem.setTitle("Conflict");
                    return problem;
                })
                .findFirst();
    }

    public static void ofThrow(DataIntegrityViolationException exception) {
        String message = exception.getMessage();
        if (message == null) throw exception;

        ITEMS.entrySet().stream()
                .filter(entry -> message.contains(entry.getKey()))
                .map(entry -> entry.getValue().get())
                .findFirst()
                .ifPresentOrElse(ex -> { throw ex; }, () -> { throw exception; });
    }

}