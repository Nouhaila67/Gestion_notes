package com.example.gestions_des_notes.service;

import com.example.gestions_des_notes.models.Student;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document; // ✅ Correct import
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table; // ✅ Corrected import
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PDFExportService {

    public byte[] generateStudentPDF(List<Student> students) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Student List").setBold().setFontSize(18));

            Table table = new Table(new float[]{1, 2, 2, 2}); // ✅ Fixed "Tabble" to "Table"
            table.addHeaderCell("ID").addHeaderCell("CNE").addHeaderCell("First Name").addHeaderCell("Last Name");

            for (Student student : students) {
                table.addCell(String.valueOf(student.getId()));
                table.addCell(student.getCne());
                table.addCell(student.getFirstName());
                table.addCell(student.getLastName());
            }

            document.add(table);
            document.close();

            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
