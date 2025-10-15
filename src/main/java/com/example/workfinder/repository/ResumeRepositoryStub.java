package com.example.workfinder.repository;

import com.example.workfinder.entity.Resume;
import com.example.workfinder.entity.User;
import com.example.workfinder.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeRepositoryStub {

    private final List<Resume> resumes = new ArrayList<>();

    public ResumeRepositoryStub() {
        resumes.add(
                Resume.builder()
                        .worker(User.builder()
                                .firstName("User1")
                                .surname("Surname1")
                                .patronymic("Patronymic1")
                                .email("Email1")
                                .password("abc")
                                .phone("1234567")
                                .dateOfBirth(LocalDate.now())
                                .role(UserRole.EMPLOYEE)
                                .build())
                        .title("Find a job")
                        .description("Find a job description")
                        .experience("Professional gamer in minecraft")
                        .education("3rd grade school")
                        .skills("Reading")
                        .location("I don't know")
                        .employmentType("I would like to work 5 minutes per day")
                        .datePosted(LocalDate.now())
                        .isActive(true)
                        .build()
        );
    }
}