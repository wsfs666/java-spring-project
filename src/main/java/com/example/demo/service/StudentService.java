package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public List<Student> getAllStudents(){
        return studentDao.SelectAllStudent();
    }
}
