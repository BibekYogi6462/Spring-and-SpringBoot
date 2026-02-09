package com.bibek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibek.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
