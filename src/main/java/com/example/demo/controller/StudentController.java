package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        Student s=new Student(UUID.randomUUID(),"testname");
        return studentService.getAllStudents();

    }

    //get: 不改变数据库中数据
    //post：改变数据库中数据  add
    //put: update
    @PostMapping
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "added student";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "update student";
    }

    @DeleteMapping(path="{id}")
    //path="{id1}/{id2}"
    //localhost:8080/api/student/123/234
    //path
    public String deleteStudent(@PathVariable("id") UUID id){
        //(@PathVariable("id1") UUID id1, @PathVariable("id2") UUID id2)
        studentService.deleteStudent(id);
        return "delete student";
    }


}
