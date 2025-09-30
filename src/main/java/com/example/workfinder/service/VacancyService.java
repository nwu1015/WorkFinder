package com.example.workfinder.service;

import com.example.workfinder.entity.Vacancy;
import com.example.workfinder.repository.VacancyRepositoryStub;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepositoryStub vacancyRepositoryStub;

    public List<Vacancy> getVacancies() {
        return vacancyRepositoryStub.getVacancies();
    }

    public void removeVacancyById(int id) {
        for (Vacancy v : vacancyRepositoryStub.getVacancies()) {
            if (v.getId() == id) {
                vacancyRepositoryStub.removeVacancy(v);
                break;
            }
        }
    }

    public void createVacancy(String nameOfVacancy, String requirements, int salary, String location,
                              String employmentType, String experience, String description) {

        Vacancy vacancy = new Vacancy(nameOfVacancy, requirements, salary, location,
                employmentType, experience, description, LocalDate.now(), true);

        vacancyRepositoryStub.saveVacancy(vacancy);
    }

    public Vacancy getVacancyById(int id) {
        return vacancyRepositoryStub.getVacancyById(id);
    }

    public void updateVacancy(Vacancy vacancy) {
        Vacancy existingVacancy = vacancyRepositoryStub.getVacancyById(vacancy.getId());
        if (existingVacancy != null) {
            existingVacancy.setNameOfVacancy(vacancy.getNameOfVacancy());
            existingVacancy.setRequirements(vacancy.getRequirements());
            existingVacancy.setSalary(vacancy.getSalary());
            existingVacancy.setLocation(vacancy.getLocation());
            existingVacancy.setEmploymentType(vacancy.getEmploymentType());
            existingVacancy.setExperience(vacancy.getExperience());
            existingVacancy.setDescription(vacancy.getDescription());
            existingVacancy.setActive(vacancy.isActive());
        } else {
            throw new RuntimeException("Vacancy not found with id: " + vacancy.getId());
        }
    }

    public List<Vacancy> searchVacancies(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getVacancies();
        }
        String lowerKeyword = keyword.toLowerCase();
        return vacancyRepositoryStub.getVacancies().stream()
                .filter(v -> v.getNameOfVacancy().toLowerCase().contains(lowerKeyword)
                        || v.getRequirements().toLowerCase().contains(lowerKeyword))
                .collect(Collectors.toList());
    }
}