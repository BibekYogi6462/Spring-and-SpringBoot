package com.bibek.RestAPIs.service.impl;

import com.bibek.RestAPIs.dto.StudentDto;
import com.bibek.RestAPIs.entity.Student;
import com.bibek.RestAPIs.repository.StudentRepository;
import com.bibek.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtolist = students.stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
        return studentDtolist;


    }
}
