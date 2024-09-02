package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.*;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import com.digitalacademy.monetab.services.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping()
@Slf4j
public class IndexController {

    @Autowired
    private InitAppService initAppService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private AppSettingService appSettingService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleUserService roleUserService;

    @GetMapping
    public String indexSet(Model model) {

        List<SchoolDTO> schools = schoolService.findAll();
        List<AppSettingDTO> appSetting = appSettingService.findAll();

        if(!schools.isEmpty() && !appSetting.isEmpty()) {
            return "redirect:/login";
        }else{
            model.addAttribute("appSetting", new AppSettingDTO());
            return "inits/setting";
        }

    }

    @PostMapping
    public String saveSet(AppSettingDTO appSettingDTO) {
        initAppService.initAppSetting(appSettingDTO);
        return "redirect:/school";
    }

    @GetMapping("school")
    public String indexSch(Model model){
        model.addAttribute("School" , new SchoolDTO());
        return "inits/school";
    }

    @PostMapping("school")
    public String saveSch(SchoolDTO schoolDTO){
        AppSettingDTO appSettingDTO = appSettingService.findAll().get(0);
        initAppService.initSchool(schoolDTO , appSettingDTO);

        RoleUserDTO roleUserDTO = new RoleUserDTO();
        roleUserDTO.setNameRole("ADMIN");

        initAppService.initRoleUsers(CreateRoleUser());
        userService.initUsers(CreateUser());

        return "redirect:/login";
    }

    public List<RoleUserDTO> CreateRoleUser(){
        List<RoleUserDTO> roleUserDTOList = new ArrayList<>();

        RoleUserDTO roleUserDTO1 = new RoleUserDTO();
        roleUserDTO1.setNameRole("ADMIN");
        roleUserDTOList.add(roleUserDTO1);

        RoleUserDTO roleUserDT02 = new RoleUserDTO();
        roleUserDT02.setNameRole("USER");
        roleUserDTOList.add(roleUserDT02);

        return roleUserDTOList;
    }

    public List<UserDTO> CreateUser(){
        List<UserDTO> userDTOList = new ArrayList<>();
        SchoolDTO schoolDTO = schoolService.findAll().get(0);

        log.debug("{}", schoolDTO);

        List<RoleUserDTO> roleUserDTOList = roleUserService.findAll();
        List<RoleUserDTO> roleUserADMIN = new ArrayList<>();
        roleUserADMIN.add(roleUserDTOList.get(0));

		List<RoleUserDTO> roleUserUSER = new ArrayList<>();
        roleUserUSER.add(roleUserDTOList.get(1));

        UserDTO userAdmin = new UserDTO();
		userAdmin.setPseudo("admin");
		userAdmin.setPassword("admin");
		userAdmin.setCreatedDate(Instant.now());
		userAdmin.setSchool(schoolDTO);
		userAdmin.setRoleUser(roleUserADMIN);
        userDTOList.add(userAdmin);

		UserDTO userUser = new UserDTO();
		userUser.setPseudo("user");
		userUser.setPassword("user");
		userUser.setCreatedDate(Instant.now());
		userUser.setSchool(schoolDTO);
		userUser.setRoleUser(roleUserUSER);
        userDTOList.add(userUser);

        return userDTOList;

    }

}
