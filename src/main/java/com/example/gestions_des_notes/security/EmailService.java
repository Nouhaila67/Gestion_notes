package com.example.gestions_des_notes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendStudentAddedEmail(String recipient, String studentName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject("New Student Added");
        message.setText("A new student named " + studentName + " has been added to the system.");

        mailSender.send(message);
    }
}
