package com.digitalacademy.monetab;

import com.digitalacademy.monetab.repositories.StudentRepository;
import com.digitalacademy.monetab.services.*;

import com.digitalacademy.monetab.services.dto.*;
import com.digitalacademy.monetab.services.impl.UserServiceImpl;
import com.digitalacademy.monetab.services.mapper.RoleUserMapper;
import com.digitalacademy.monetab.services.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.*;


@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

//
//	@Autowired
//	private AppSettingService appSettingService;
//
//	@Autowired
//	private SchoolService schoolService;
//
//	@Autowired
//	private RoleUserService roleUserService;
//    @Autowired
//    private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		AppSettingDTO appSettingDTO = new AppSettingDTO();
//
//		appSettingDTO.setSmtpServer("mail");
//		appSettingDTO.setSmtpUsername("monEcole");
//		appSettingDTO.setSmtpPassword("monEcole123");
//		appSettingDTO.setSmtpPort("587");
//
//		AppSettingDTO settingDTO = appSettingService.initAppSetting(appSettingDTO);
//
//		SchoolDTO schoolDTO = new SchoolDTO();
//		schoolDTO.setNameSchool("upb");
//		schoolDTO.setUrlLogo("https://cdn-icons-png.freepik.com/256/8074/8074788.png?semt=ais_hybrid");
//		schoolDTO.setAppSetting(settingDTO);
//		schoolDTO = schoolService.initSchool(schoolDTO);
//
//		RoleUserDTO role01 = new RoleUserDTO();
//		role01.setNameRole("ADMIN");
//
//		RoleUserDTO role02 = new RoleUserDTO();
//		role02.setNameRole("USER");
//
//		RoleUserDTO role03 = new RoleUserDTO();
//		role03.setNameRole("OTHER");
//
//		List<RoleUserDTO> roleUserDTOList = Arrays.asList(role01 , role02 , role03);
//		roleUserDTOList = roleUserService.initRoles(roleUserDTOList);
//
//		List<RoleUserDTO> roleUserAdmin = new ArrayList<>();
//		roleUserAdmin.add(roleUserDTOList.get(0));
//
//		List<RoleUserDTO> roleUserUSER = new ArrayList<>();
//		roleUserUSER.add(roleUserDTOList.get(1));
//
//		List<RoleUserDTO> roleUserOTHER = new ArrayList<>();
//		roleUserOTHER.add(roleUserDTOList.get(2));
//
//
//		UserDTO userAdmin = new UserDTO();
//		userAdmin.setPseudo("admin");
//		userAdmin.setPassword("admin");
//		userAdmin.setCreatedDate(Instant.now());
//		userAdmin.setSchool(schoolDTO);
//		userAdmin.setRoleUser(roleUserAdmin);
//
//		UserDTO userUser = new UserDTO();
//		userUser.setPseudo("user");
//		userUser.setPassword("user");
//		userUser.setCreatedDate(Instant.now());
//		userUser.setSchool(schoolDTO);
//		userUser.setRoleUser(roleUserUSER);
//
//		UserDTO userOther = new UserDTO();
//		userOther.setPseudo("other");
//		userOther.setPassword("other");
//		userOther.setCreatedDate(Instant.now());
//		userOther.setSchool(schoolDTO);
//		userOther.setRoleUser(roleUserOTHER);
//
//		List<UserDTO> users = List.of(userAdmin, userUser, userOther);
//		userService.initUsers(users);
	}
}
