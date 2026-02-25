package com.bibek.RestAPIDemo3.services;

import com.bibek.RestAPIDemo3.beans.Student;
import com.bibek.RestAPIDemo3.dao.StudentDao;

import java.util.List;

public interface StudentService {

    public Student addStudent(Student std);
    public List<Student> getAllStudent();
    public Student getStudentDetails(int id);
    public Student updateStudent(Student std);

}
