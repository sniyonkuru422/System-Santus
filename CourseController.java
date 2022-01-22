package com.example.daviscollegeapp.controller;

import com.example.daviscollegeapp.entity.Course;
import com.example.daviscollegeapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository repository;
    @GetMapping("/Courses")
    public String viewCourse(Model model){
        model.addAttribute("CoursesList",repository.findAll());
        return "Courses";
    }

    @PostMapping("/coadd")
    public String coadd(Course course, Model model){
        model.addAttribute("course",new Course());
        repository.save(course);
        return "redirect:/Courses";
    }

   @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/Courses";
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable("id") Integer id, Model model){
        model.addAttribute("course", repository.findById(id).get());
        return"editCourse";
    }

}
