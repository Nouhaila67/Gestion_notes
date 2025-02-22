package com.example.gestions_des_notes.service;

import com.example.gestions_des_notes.models.Student;
import java.util.List;
import java.util.Optional;

    public interface StudentService {
        List<Student> getAllStudents();
        Optional<Student> getStudentById(Long id);
        Student createStudent(Student student);
        boolean deleteStudent(Long id);
    }

