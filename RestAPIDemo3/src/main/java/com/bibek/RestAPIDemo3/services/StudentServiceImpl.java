package com.bibek.RestAPIDemo3.services;

import com.bibek.RestAPIDemo3.beans.Student;
import com.bibek.RestAPIDemo3.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    StudentDao studentDao;

    @Override
    public Student addStudent(Student std) {
        Student student = studentDao.save(std);
        return  student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> student_lists = studentDao.findAll();
        return student_lists;
    }

    @Override
    public Student getStudentDetails(int id) {
        Optional<Student> optional = studentDao.findById(id);
        return optional.get();
    }

    @Override
    public Student updateStudent(Student std) {
        Student student = studentDao.save(std);
        return student;
    }


}
