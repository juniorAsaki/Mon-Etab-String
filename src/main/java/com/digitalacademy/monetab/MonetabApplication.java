package com.digitalacademy.monetab;

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

		Teacher teacher = new Teacher();
		teacher.setMatiere("Java");

		Teacher teacher1 = new Teacher();
		teacher1.setMatiere("Python");

		Teacher teacher2 = new Teacher();
		teacher2.setMatiere("PHP");


		teacherService.save(teacher);
		teacherService.save(teacher1);
		teacherService.save(teacher2);


//		FileNote fileNote = new FileNote();
//		fileNote.setNote(13.0);
//		fileNote.setTeacher(teacher);
//
//		FileNote fileNote1 = new FileNote();
//		fileNote.setNote(14.0);
//		fileNote.setTeacher(teacher1);
//
//		fileNoteService.save(fileNote);
//		fileNoteService.save(fileNote1);

		List<Teacher> teachers = teacherService.findAll();

		System.out.println(teachers);


	}
}
