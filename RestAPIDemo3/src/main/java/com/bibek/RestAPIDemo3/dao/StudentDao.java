package com.bibek.RestAPIDemo3.dao;

import com.bibek.RestAPIDemo3.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
}
