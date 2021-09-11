package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    List<Student> SelectAllStudent();
    int insertStudent(UUID id,Student student);
}
