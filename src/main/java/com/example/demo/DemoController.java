package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class DemoController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) throws Exception{
        return this.studentService.getStudentByID(id);
    }

    @PostMapping("/students")
    public Student createNewStudent(@RequestBody Student newStudent) {
        Random rand = new Random();
        int upperbound = 10000;
        int int_random = rand.nextInt(upperbound);
        newStudent.setID(int_random);
        return this.studentRepository.save(newStudent);
    }

    @DeleteMapping("/students/{id}")
    void deleteEmployee(@PathVariable int id) {
        this.studentRepository.deleteById(id);
    }

}