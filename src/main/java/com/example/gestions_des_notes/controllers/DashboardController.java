package com.example.gestions_des_notes.controllers;
import com.example.gestions_des_notes.DAO.StudentRepo;
import com.example.gestions_des_notes.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/")
    public String showDashboard(Model model) {
        long studentCount = studentRepo.count();

        // ✅ Retrieve students and group them by level
        List<Student> students = studentRepo.findAll();
        Map<String, Long> studentsByLevel = students.stream()
                .collect(Collectors.groupingBy(Student::getLevel, Collectors.counting()));

        model.addAttribute("studentCount", studentCount);
        model.addAttribute("studentsByLevel", studentsByLevel);
        return "dashboard";
    }
}


