package com.example.workfinder.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@ToString
public class User {

    //private int id;

    private String firstName;
    private String surname;
    private String patronymic;
    private String email;
    private String password;
    private String phone;
    private LocalDate dateOfBirth;
    private UserRole role;
}
