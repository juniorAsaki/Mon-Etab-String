package com.digitalacademy.monetab;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.FileNoteService;
import com.digitalacademy.monetab.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;



@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

	@Autowired
	private FileNoteService fileNoteService;
	@Autowired
	private TeacherService teacherService;



    public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
