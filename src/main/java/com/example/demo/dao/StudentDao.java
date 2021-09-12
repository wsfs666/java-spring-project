package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {

    List<Student> SelectAllStudent();

    int insertStudent(Student student);

    int updateStudent(Student student);

    Optional<Student> SelectByID(UUID id);

    int deleteStudentById(UUID id);


}
