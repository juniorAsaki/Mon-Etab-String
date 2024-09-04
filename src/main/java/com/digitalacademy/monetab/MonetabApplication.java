package com.digitalacademy.monetab;

import com.digitalacademy.monetab.repositories.StudentRepository;
import com.digitalacademy.monetab.services.*;

import com.digitalacademy.monetab.services.dto.*;
import com.digitalacademy.monetab.services.impl.UserServiceImpl;
import com.digitalacademy.monetab.services.mapper.RoleUserMapper;
import com.digitalacademy.monetab.services.mapper.StudentMapper;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
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
    @Autowired
    private StudentService studentService;


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


		List<StudentDTO> studentDTOS = studentService.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Students");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("MATRICLE");
		row.createCell(1).setCellValue("NOM");
		row.createCell(2).setCellValue("PRENOM");
		row.createCell(3).setCellValue("TELEPHONE");
		row.createCell(4).setCellValue("DATE DE NAISSANCE");
		row.createCell(5).setCellValue("URL PICTURE");

		HSSFCellStyle dateCellStyle = workbook.createCellStyle();
		HSSFDataFormat dateFormat = workbook.createDataFormat();
		dateCellStyle.setDataFormat(dateFormat.getFormat("dd-mm-yyyy"));

		int dataRowIndex = 1;

		for (StudentDTO student : studentDTOS) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(student.getMatricule());
			dataRow.createCell(1).setCellValue(student.getFirstName());
			dataRow.createCell(3).setCellValue(student.getLastName());
			dataRow.createCell(4).setCellValue(student.getNumbers());
			dataRow.createCell(5).setCellValue(student.getDateOfBirth());
			dataRow.createCell(6).setCellValue(student.getUrlPicture());

			if(student.getDateOfBirth() != null) {
				HSSFCell dateCell = dataRow.createCell(5);
				dateCell.setCellValue(Date.valueOf(student.getDateOfBirth().toLocalDate()));
				dateCell.setCellStyle(dateCellStyle);
			}

			dataRowIndex++;
		}

		for (int i = 0; i < 4; i++) {
			sheet.autoSizeColumn(i);
		}
	}
}
