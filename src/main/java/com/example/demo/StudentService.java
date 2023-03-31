package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentByID(int id) throws Exception {
        Optional<Student> student = studentRepository.findByID(id);
        if(student.isEmpty()){
            throw new Exception("Student not found");
        }
        return student.get();
    }


}