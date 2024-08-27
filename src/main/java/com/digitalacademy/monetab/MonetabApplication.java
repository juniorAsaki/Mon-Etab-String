package com.digitalacademy.monetab;

import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;



    public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
