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
public class Resume {

    private User worker;

    private String title;
    private String description;
    private String experience;
    private String education;
    private String skills;
    private String location;
    private String employmentType;
    private LocalDate datePosted;
    private boolean isActive;
}
