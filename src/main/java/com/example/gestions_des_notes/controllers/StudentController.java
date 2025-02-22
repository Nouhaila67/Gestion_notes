package com.example.gestions_des_notes.controllers;

import com.example.gestions_des_notes.models.Student;
import com.example.gestions_des_notes.service.ExcelExportService;
import com.example.gestions_des_notes.service.PDFExportService;
import com.example.gestions_des_notes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Remplace @Controller pour permettre les réponses API
@RequestMapping("/api") // Ajout d'un préfixe pour mieux organiser les routes
public class StudentController {

    private final StudentService studentService;
    private final PDFExportService pdfExportService;
    private final ExcelExportService excelExportService;

    // Injection de dépendances via constructeur
    @Autowired
    public StudentController(StudentService studentService, PDFExportService pdfExportService, ExcelExportService excelExportService) {
        this.studentService = studentService;
        this.pdfExportService = pdfExportService;
        this.excelExportService = excelExportService;
    }

    // ✅ Endpoint pour exporter en PDF
    @GetMapping("/students/export/pdf")
    public ResponseEntity<byte[]> exportToPDF() {
        List<Student> students = studentService.getAllStudents();

        if (students == null || students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        byte[] pdfBytes = pdfExportService.generateStudentPDF(students);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=students.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    // ✅ Endpoint pour exporter en Excel
    @GetMapping("/students/export/excel")
    public ResponseEntity<byte[]> exportToExcel() {
        List<Student> students = studentService.getAllStudents();

        if (students == null || students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        byte[] excelBytes = excelExportService.generateStudentExcel(students);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=students.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelBytes);
    }
}
