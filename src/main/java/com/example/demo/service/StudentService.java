package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private StudentDao studentDao;
//依赖注入
    @Autowired
    //
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public List<Student> getAllStudents(){
        return studentDao.SelectAllStudent();
    }

    public int addStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public int updateStudent(Student student){
        return studentDao.updateStudent(student);
    }
    public int deleteStudent(UUID id){
        return studentDao.deleteStudentById(id);
    }
}
