package com.example.daviscollegeapp.controller;

import com.example.daviscollegeapp.entity.Student;
import com.example.daviscollegeapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @GetMapping("/Students")
    public String viewStudents(Model model) {
        model.addAttribute("StudentsList", repository.findAll());
        return "Students";
    }

    @PostMapping("/addSt")
    public String addSt(Student student, Model model) {
        model.addAttribute("student", new Student());
        repository.save(student);
        return "redirect:/Students";
    }

    @GetMapping("/delete2/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return "redirect:/Students";
    }

    @GetMapping("/edit2/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("studentList", repository.getById(id));
        return "editStudent";
    }
}