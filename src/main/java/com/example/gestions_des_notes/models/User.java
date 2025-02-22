package com.example.gestions_des_notes.models;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    private String password; // Store hashed password
    private String role; // ADMIN_NOTES, ADMIN_SP, ADMIN_USER
    private Boolean enabled = true;
    private Boolean locked = false;

}
