package com.negoreserva.internal.client.util;

import com.negoreserva.common.feature.concrete.category.exception.unique.CategoryNameAlreadyExistsException;
import com.negoreserva.common.feature.concrete.user.exception.unique.UserEmailAlreadyExistsException;
import com.negoreserva.common.feature.concrete.user.exception.unique.UserPhoneAlreadyExistsException;
import com.negoreserva.common.feature.core.variable.ConstraintsUniqueItem;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;
import java.util.List;

public final class ClientRegisterConstraintsExceptions {

    public static final List<ConstraintsUniqueItem> items = List.of(
            new ConstraintsUniqueItem("tb_cli_users_phone_key", "User phone already exists",  UserPhoneAlreadyExistsException::new),
            new ConstraintsUniqueItem("tb_cli_users_email_key", "User email already exists",  UserEmailAlreadyExistsException::new),
            new ConstraintsUniqueItem("tb_cli_categories_name_key", "Category name already exists",  CategoryNameAlreadyExistsException::new)
    );

    public static Optional<ConstraintsUniqueItem> of(DataIntegrityViolationException exception) {
        var message = exception.getMessage();
        return items.stream()
                .filter(entry -> message.contains(entry.key()))
                .findFirst();
    }

}