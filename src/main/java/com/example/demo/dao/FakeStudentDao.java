package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//dao中若同时有两个实现文件(javabean) 会产生混淆 不能执行
//1.可以用 @Qualifier("fakeStudentDao")（StudentService文件）来指定 StudentDao 实现哪个javabean
//2. @Repository("dao1") ->javabean 文件
//   @Qualifier("dao1") ->StudentService文件

@Repository
public class FakeStudentDao implements StudentDao{
    private static List<Student> database = new ArrayList<>();

    @Override
    public List<Student> SelectAllStudent() {
        return database;
    }
    @Override
    public Optional<Student> SelectByID(UUID id) {
        for (Student s :database){
            if(s.getId().equals(id)){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
    @Override
    public int insertStudent(Student student) {
        UUID id =UUID.randomUUID();
        database.add(new Student(id, student.getName()));
        return 1;
    }

    @Override
    public int updateStudent(Student student) {
       /* Optional<Student> optionalStudent= SelectByID(student.getId());
        if(!optionalStudent.isPresent()){  //can't find id in dataset
            return -1;
        }*/

        int indexToUpdate=-1;
       for(int i=0;i<database.size();i++){
           if(student.getId().equals(database.get(i).getId())){
               indexToUpdate=i;
               break;
           }
       }
       if(indexToUpdate<0){
           return -1;
       }
       database.set(indexToUpdate,student);
       return 1;

    }

    @Override
    public int deleteStudentById(UUID id) {
         Optional<Student> optionalStudent= SelectByID(id);
        if(!optionalStudent.isPresent()){  //can't find id in dataset
            return -1;
        }
        database.remove(optionalStudent.get());
        return 1;
    }
}
