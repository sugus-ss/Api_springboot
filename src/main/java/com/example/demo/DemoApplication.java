package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private StudentRepository studentRepository;
	@PostConstruct
	public void initialData(){
		Student student = new Student();
		student.setName("JoJo");
		student.setID(1112);
		studentRepository.save(student);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}