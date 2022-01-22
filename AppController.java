package com.example.daviscollegeapp.controller;

import com.example.daviscollegeapp.entity.Course;
import com.example.daviscollegeapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    CourseRepository CourseRepository;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("courses", new Course());
        model.addAttribute("CoursesList", CourseRepository.findAll());
        return "index";
    }
}