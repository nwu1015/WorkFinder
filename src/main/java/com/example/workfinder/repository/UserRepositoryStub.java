package com.example.workfinder.repository;

import com.example.workfinder.entity.User;
import com.example.workfinder.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryStub {
    private final List<User> users = new ArrayList<>();

    public UserRepositoryStub() {
        users.add(User.builder()
                .firstName("User1")
                .surname("Surname1")
                .patronymic("Patronymic1")
                .email("Email1")
                .password("abc")
                .phone("1234567")
                .dateOfBirth(LocalDate.now())
                .role(UserRole.EMPLOYEE)
                .build()

        );

        users.add(User.builder()
                .firstName("User2")
                .surname("Surname2")
                .patronymic("Patronymic2")
                .email("Email2")
                .password("abc")
                .phone("abc123")
                .dateOfBirth(LocalDate.now())
                .role(UserRole.EMPLOYER)
                .build()

        );

        users.add(User.builder()
                .firstName("Admin1")
                .surname("Surname")
                .patronymic("Patronymic1")
                .email("Email3")
                .password("abc")
                .phone("123")
                .dateOfBirth(LocalDate.now())
                .role(UserRole.ADMIN)
                .build()

        );
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
