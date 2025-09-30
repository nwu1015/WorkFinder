package com.example.workfinder.controller;

import com.example.workfinder.entity.Vacancy;
import com.example.workfinder.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WorkController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/getAllVacancies")
    public ModelAndView getAllVacancies() {
        return new ModelAndView("list")
                .addObject("vacancyList", vacancyService.getVacancies());
    }

    @PostMapping("/deleteVacancy/{id}")
    public ModelAndView deleteVacancyById(@PathVariable int id) {

        vacancyService.removeVacancyById(id);
        return new ModelAndView("redirect:/getAllVacancies");
    }

    @PostMapping("/createVacancy")
    public ModelAndView createVacancy(
            @RequestParam("nameOfVacancy") String nameOfVacancy,
            @RequestParam("requirements") String requirements,
            @RequestParam("salary") int salary,
            @RequestParam("location") String location,
            @RequestParam("employmentType") String employmentType,
            @RequestParam("experience") String experience,
            @RequestParam("description") String description
    ) {

        vacancyService.createVacancy(nameOfVacancy, requirements, salary,
                location, employmentType, experience, description);

        return new ModelAndView("redirect:/getAllVacancies");
    }

    @GetMapping("/editVacancy/{id}")
    public ModelAndView editVacancy(@PathVariable int id){
        Vacancy vacancy = vacancyService.getVacancyById(id);
        return new ModelAndView("vacancyEdit").addObject("vacancy", vacancy);
    }

    @PostMapping("/editVacancy")
    public ModelAndView editVacancy(@ModelAttribute Vacancy vacancy) {
        vacancyService.updateVacancy(vacancy);
        return new ModelAndView("redirect:/getAllVacancies");
    }

    @GetMapping("/searchVacancies")
    public ModelAndView searchVacancies(@RequestParam("keyword") String keyword) {
        List<Vacancy> result = vacancyService.searchVacancies(keyword);
        return new ModelAndView("list")
                .addObject("vacancyList", result)
                .addObject("keyword", keyword);
    }
}
