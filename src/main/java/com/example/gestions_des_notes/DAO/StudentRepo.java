package com.example.gestions_des_notes.DAO;

import com.example.gestions_des_notes.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; //

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    // ✅ Recherche d'un étudiant par prénom (sans tenir compte des majuscules/minuscules)
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
}
