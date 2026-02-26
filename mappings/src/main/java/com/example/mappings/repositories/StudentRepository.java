package com.example.mappings.repositories;

import com.example.mappings.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {



}
