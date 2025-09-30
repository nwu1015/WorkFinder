package com.example.workfinder.configuration;

import com.example.workfinder.entity.Vacancy;
import com.example.workfinder.repository.VacancyRepositoryStub;
import com.example.workfinder.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class VacancyConfig {

    @Bean
    @Scope("prototype")
    public Vacancy vacancy() {

        return new Vacancy(
                "beanPrototype", "", 0, "",
                "", "", "", LocalDate.now(), true);
    }
}
