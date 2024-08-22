package com.digitalacademy.monetab;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;


    public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student(null , "Kdev2024" );
		studentService.save(student);


	}
}
