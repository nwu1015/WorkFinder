package com.example.workfinder.entity;

import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class Vacancy {

    static int counter = 0;

    int id;
    String nameOfVacancy;
    String requirements;
    int salary;
    String location;
    String employmentType;
    String experience;
    String description;
    LocalDate dateOfVacancy;
    boolean isActive;

    public Vacancy(String nameOfVacancy, String requirements, int salary, String location,
                   String employmentType, String experience, String description,
                   LocalDate dateOfVacancy, boolean isActive) {
        this.id = ++counter;
        this.nameOfVacancy = nameOfVacancy;
        this.requirements = requirements;
        this.salary = salary;
        this.location = location;
        this.employmentType = employmentType;
        this.experience = experience;
        this.description = description;
        this.dateOfVacancy = dateOfVacancy;
        this.isActive = isActive;
    }
}
