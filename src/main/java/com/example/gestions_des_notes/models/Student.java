package com.example.gestions_des_notes.models;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level currentLevel;
    private String cne;
    private String firstName;
    private String lastName;

    // ✅ Add this field (Student's level)
    private String level;

    public Student(Long id, String cne, String firstName, String lastName, String level) {
        this.id = id;
        this.cne = cne;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
