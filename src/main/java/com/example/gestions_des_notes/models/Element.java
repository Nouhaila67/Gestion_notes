package com.example.gestions_des_notes.models;

import jakarta.persistence.*;

@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    private String coordinator;

    // Getters and setters
}
