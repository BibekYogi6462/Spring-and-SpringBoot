package com.bibek.RestAPIs.controller;

import com.bibek.RestAPIs.dto.StudentDto;
import com.bibek.RestAPIs.entity.Student;
import com.bibek.RestAPIs.repository.StudentRepository;
import com.bibek.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    private final StudentRepository studentRepository;

    @GetMapping("/students")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}/{name}")
    public String getStudentById(@PathVariable Long id, @PathVariable String name){
      return "Path Variable"+id+name;
    }
}
