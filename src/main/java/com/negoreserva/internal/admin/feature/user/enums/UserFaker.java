package com.negoreserva.internal.admin.feature.user.enums;

import com.negoreserva.common.feature.concrete.user.enums.UserType;
import com.negoreserva.common.feature.concrete.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

@Getter
@AllArgsConstructor
public enum UserFaker {
    JOHN(User.builder()
            .name("John Doe")
            .username("john.john#client")
            .email("john.john@example.com")
            .phone("1234567890")
            .password("password123")
            .birthday(LocalDate.of(1990, 1, 15))
            .type(UserType.ORGANIZATION)
            .build()),
    JANE(User.builder()
            .name("Jane Smith")
            .username("jane.smith#client")
            .email("jane.smith@example.com")
            .phone("9876543210")
            .password("password456")
            .birthday(LocalDate.of(1985, 6, 20))
            .type(UserType.ORGANIZATION)
            .build()),
    BOB(User.builder()
            .name("Bob Wilson")
            .username("bob.wilson#client")
            .email("bob.wilson@example.com")
            .phone("5555555555")
            .password("password789")
            .birthday(LocalDate.of(1992, 3, 10))
            .type(UserType.ORGANIZATION)
            .build()),
    MARIA(User.builder()
            .name("Maria Silva")
            .username("maria.silva#client")
            .email("maria.silva@pousada.com")
            .phone("5535123456789")
            .password("passwordmaria")
            .birthday(LocalDate.of(1988, 7, 22))
            .type(UserType.ORGANIZATION)
            .build()),
    PEDRO(User.builder()
            .name("Pedro Santos")
            .username("pedro.santos#client")
            .email("pedro.santos@pensao.com")
            .phone("5531988887777")
            .password("passwordpedro")
            .birthday(LocalDate.of(1975, 11, 5))
            .type(UserType.ORGANIZATION)
            .build()),
    ANA(User.builder()
            .name("Ana Costa")
            .username("ana.costa#client")
            .email("ana.costa@restaurante.com")
            .phone("5511988889999")
            .password("passwordana")
            .birthday(LocalDate.of(1991, 2, 14))
            .type(UserType.ORGANIZATION)
            .build()),
    CARLOS(User.builder()
            .name("Carlos Oliveira")
            .username("carlos.oliveira#client")
            .email("carlos.oliveira@loja.com")
            .phone("551133334444")
            .password("passwordcarlos")
            .birthday(LocalDate.of(1983, 9, 30))
            .type(UserType.ORGANIZATION)
            .build());

    private final User user;

    public static List<User> listUsers() {
        return Arrays.stream(UserFaker.values()).map(UserFaker::getUser).toList();
    }

    public static User random() {
        var users = listUsers();
        var random = RandomGenerator.getDefault();
        var index = random.nextInt(users.size());
        return users.get(index);
    }
}
