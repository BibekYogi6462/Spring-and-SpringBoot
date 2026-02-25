package com.bibek.RestAPIDemo3.contollers;

import com.bibek.RestAPIDemo3.beans.Student;
import com.bibek.RestAPIDemo3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    StudentService studentService;

//    @PostMapping("/student")
//    public Student addStudent(@RequestParam("id1") int id,
//                              @RequestParam("name1") String name,
//                              @RequestParam("gender1") String gender,
//                              @RequestParam("city1") String city) {
//
//        Student std = new Student();
//        std.setId(id);
//        std.setName(name);
//        std.setGender(gender);
//        std.setCity(city);
//
//        Student student = studentService.addStudent(std);
//        return student;
//    }
@PostMapping("/student")
public Student addStudent(@RequestBody Student std) {

    Student student = studentService.addStudent(std);
    return student;
}

@GetMapping("/student")
public List<Student> getAllStudent(){
    List<Student> students_list = studentService.getAllStudent();
    return students_list;

}


@GetMapping("/student/${id1}")
public Student getStudentDetails(@PathVariable("id1") int id){
    Student std  = studentService.getStudentDetails(id);
    return std;

}

@PutMapping("/student")
public Student updateStudent(@RequestBody Student std){
    Student student = studentService.updateStudent(std);
    return student;
}


}