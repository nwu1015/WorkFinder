package com.example.workfinder.repository;

import com.example.workfinder.entity.Vacancy;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VacancyRepositoryStub {
    @Getter
    private final List<Vacancy> vacancies = new ArrayList<>();

    private ApplicationContext applicationContext;

    public VacancyRepositoryStub() {
        vacancies.add(new Vacancy("Java Dev", "Spring, SQL",
                2000, "Kyiv", "Full-time",
                "2 years", "Backend developer", LocalDate.now(), true));

        vacancies.add(new Vacancy("QA Engineer", "Selenium",
                1500, "Lviv", "Full-time",
                "1 year", "Testing web apps", LocalDate.now(), true));
    }

    @PostConstruct
    public void init(){
        Vacancy prototypeVacancy = applicationContext.getBean(Vacancy.class);
        vacancies.add(prototypeVacancy);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Vacancy getVacancyById(int id) {
        for (Vacancy vacancy : vacancies) {
            if (vacancy.getId() == id) {
                return vacancy;
            }
        }
        return null;
    }

    public void removeVacancy(Vacancy vacancy) {
        vacancies.remove(vacancy);
    }

    public void saveVacancy(Vacancy vacancy) {
        vacancies.add(vacancy);
    }
}
