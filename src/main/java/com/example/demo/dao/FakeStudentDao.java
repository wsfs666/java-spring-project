package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.UUID;

public class FakeStudentDao implements StudentDao{
    private static List<Student> database;

    @Override
    public List<Student> SelectAllStudent() {
        return database;
    }

    @Override
    public int insertStudent(UUID id, Student student) {
        return 0;
    }
}
