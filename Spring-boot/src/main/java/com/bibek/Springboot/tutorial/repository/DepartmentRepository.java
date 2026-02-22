package com.bibek.Springboot.tutorial.repository;

import com.bibek.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
