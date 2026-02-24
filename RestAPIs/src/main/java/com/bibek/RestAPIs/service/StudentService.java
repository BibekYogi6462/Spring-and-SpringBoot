package com.bibek.RestAPIs.service;

import com.bibek.RestAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

}
