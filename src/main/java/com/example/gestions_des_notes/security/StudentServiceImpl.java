package com.example.gestions_des_notes.security;

import com.example.gestions_des_notes.DAO.StudentRepo;
import com.example.gestions_des_notes.models.Student;
import com.example.gestions_des_notes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private EmailService emailService;

    @Override
    public Student createStudent(Student student) {
        Student savedStudent = studentRepo.save(student);
        emailService.sendStudentAddedEmail("admin@example.com", student.getFirstName() + " " + student.getLastName());
        return savedStudent;
    }

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    /*public Student createStudent() {
        return createStudent((Student) null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }*/

    @Override
    public boolean deleteStudent(Long id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
