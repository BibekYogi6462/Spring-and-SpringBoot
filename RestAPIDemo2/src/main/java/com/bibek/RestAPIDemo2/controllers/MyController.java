package com.bibek.RestAPIDemo2.controllers;


import com.bibek.RestAPIDemo2.beans.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class MyController {
//
//    @GetMapping("/printStudent")
//    public Student printStdDetails(){
//        Student std = new Student();
//        std.setName("Bibek");
//        std.setGender("Male");
//        std.setCity("Kathmandu");
//        return std;
//    }
//}

@RestController
public class MyController {

    @GetMapping("/printStudent")
    public Student printStdDetails(){
        Student std = new Student("Bibek", "Male","Kathmandu");
        return std;
    }
}
