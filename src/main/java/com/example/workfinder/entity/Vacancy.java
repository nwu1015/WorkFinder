package com.example.workfinder.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Vacancy {

    String nameOfVacancy;
    String requirements;
    int salary;
    String location;
    String employmentType;
    String experience;
    String description;
    Date dateOfVacancy;
    boolean isActive;
}
