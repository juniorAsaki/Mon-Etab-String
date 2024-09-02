package com.digitalacademy.monetab;

import com.digitalacademy.monetab.repositories.StudentRepository;
import com.digitalacademy.monetab.services.RoleUserService;

import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import com.digitalacademy.monetab.services.mapper.RoleUserMapper;
import com.digitalacademy.monetab.services.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {


	@Autowired
	private StudentRepository studentService;

	@Autowired
	private StudentMapper studentMapper;

    public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
