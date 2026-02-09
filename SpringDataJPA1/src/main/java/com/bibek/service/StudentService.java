package com.bibek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibek.entity.Student;
import com.bibek.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public boolean insertStdDetailsService(Student std) {
        studentRepository.save(std);
        return true;
    }
}
