package com.example.gestions_des_notes.models;
import jakarta.persistence.*;

@Entity
public class EducationalStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Class, Module, or Element
    private String name;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    // Getters and setters
}
