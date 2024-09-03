package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.*;
import com.digitalacademy.monetab.services.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/schools")
@Slf4j
@RequiredArgsConstructor
public class SchoolController {

    private final InitAppService initAppService;

    private final AppSettingService appSettingService;

    private final SchoolService schoolService;

    private final UserService userService;

    private final RoleUserService roleUserService;


    @GetMapping
    public String showSchoolPage(Model model){
        model.addAttribute("school" , new RegistrationSchoolDTO());
        return "inits/school";
    }

    @PostMapping
    public String saveSchool(@ModelAttribute RegistrationSchoolDTO schoolDTO) {
        AppSettingDTO appSettingDTO = appSettingService.findAll().get(0);
        initAppService.initSchool(schoolDTO , appSettingDTO);

        RoleUserDTO roleUserDTO = new RoleUserDTO();
        roleUserDTO.setNameRole("ADMIN");

        initAppService.initRoleUsers(createRoleUser());
        userService.initUsers(createUser());

        return "redirect:/login";

    }

    public List<RoleUserDTO> createRoleUser(){
        List<RoleUserDTO> roleUserDTOList = new ArrayList<>();

        RoleUserDTO roleUserDTO1 = new RoleUserDTO();
        roleUserDTO1.setNameRole("ADMIN");
        roleUserDTOList.add(roleUserDTO1);

        RoleUserDTO roleUserDT02 = new RoleUserDTO();
        roleUserDT02.setNameRole("USER");
        roleUserDTOList.add(roleUserDT02);

        return roleUserDTOList;
    }

    public List<UserDTO> createUser(){
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
