package com.example.gestions_des_notes.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alias;

    @ManyToOne
    @JoinColumn(name = "next_level_id")
    private Level nextLevel;

    @OneToMany(mappedBy = "currentLevel", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "level")
    private List<Module> modules;


}
