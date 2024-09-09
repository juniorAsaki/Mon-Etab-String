package com.digitalacademy.monetab.controllers;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.digitalacademy.monetab.services.*;
import com.digitalacademy.monetab.services.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    private final Cloudinary cloudinary;

    private final PasswordEncoder passwordEncoder;


    @GetMapping
    public String showSchoolPage(Model model) {
        Optional<SchoolDTO> schoolDTO = schoolService.findAll().stream().findFirst();
        if (schoolDTO.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("school", new RegistrationSchoolDTO());
        return "inits/school";
    }

    @GetMapping("update")
    public String updateSchool(Model model) {
        SchoolDTO school = schoolService.findAll().stream().findFirst().get();
        RegistrationSchoolDTO registrationSchool = new RegistrationSchoolDTO();
        registrationSchool.setId_school(school.getId_school());
        registrationSchool.setNameSchool(school.getNameSchool());
        registrationSchool.setUrlLogo(school.getUrlLogo());
        registrationSchool.setAppSetting(school.getAppSetting());
        model.addAttribute("school", registrationSchool);
        return "inits/config_interne/school";
    }

    @PostMapping
    public String saveSchool(@ModelAttribute RegistrationSchoolDTO schoolDTO) throws IOException {

        log.debug("{}", schoolDTO);

        // Upload the image
        Map params1 = ObjectUtils.asMap(
                "use_filename", true,
                "unique_filename", true,
                "overwrite", false
        );
        SchoolDTO schoolDTO1 = new SchoolDTO();
        schoolDTO1.setNameSchool(schoolDTO.getNameSchool());


        if (schoolDTO.getId_school() != null) {

            SchoolDTO school = schoolService.findAll().stream().findFirst().get();


            if (!schoolDTO.getFile().isEmpty()) {
                String fileUrl = cloudinary.uploader().upload(schoolDTO.getFile().getBytes(), params1).get("url").toString();
                schoolDTO1.setUrlLogo(fileUrl);
            } else {
                schoolDTO1.setUrlLogo(school.getUrlLogo());
            }

            schoolDTO1.setId_school(schoolDTO.getId_school());
            schoolDTO1.setAppSetting(school.getAppSetting());

            schoolService.save(schoolDTO1);

        } else {
            String fileUrl = cloudinary.uploader().upload(schoolDTO.getFile().getBytes(), params1).get("url").toString();
            schoolDTO1.setUrlLogo(fileUrl);
            AppSettingDTO appSettingDTO = appSettingService.findAll().stream().findFirst().orElse(null);
            initAppService.initSchool(schoolDTO1, appSettingDTO);


            initAppService.initRoleUsers(createRoleUser());
            userService.initUsers(createUser());
        }


        if (schoolDTO.getId_school() != null) {
            return "redirect:/home";
        } else {
            return "redirect:/connexion";
        }


    }

    public List<RoleUserDTO> createRoleUser() {
        List<RoleUserDTO> roleUserDTOList = new ArrayList<>();

        RoleUserDTO roleUserDTO1 = new RoleUserDTO();
        roleUserDTO1.setNameRole("ADMIN");
        roleUserDTOList.add(roleUserDTO1);

        RoleUserDTO roleUserDT02 = new RoleUserDTO();
        roleUserDT02.setNameRole("USER");
        roleUserDTOList.add(roleUserDT02);

        return roleUserDTOList;
    }

    public List<UserDTO> createUser() {
        List<UserDTO> userDTOList = new ArrayList<>();
        SchoolDTO schoolDTO = schoolService.findAll().get(0);

        log.debug("{}", schoolDTO);

        List<RoleUserDTO> roleUserDTOList = roleUserService.findAll();
        List<RoleUserDTO> roleUserADMIN = new ArrayList<>();
        roleUserADMIN.add(roleUserDTOList.get(0));

        List<RoleUserDTO> roleUserUSER = new ArrayList<>();
        roleUserUSER.add(roleUserDTOList.get(1));

        UserDTO userUser = new UserDTO();
        userUser.setPseudo("user");
        userUser.setPassword(passwordEncoder.encode("user"));
        userUser.setCreatedDate(Instant.now());
        userUser.setSchool(schoolDTO);
        userUser.setRoleUser(roleUserUSER);
        userUser.setDisable(false);
        userDTOList.add(userUser);

        UserDTO userAdmin = new UserDTO();
        userAdmin.setPseudo("admin");
        userAdmin.setPassword(passwordEncoder.encode("admin"));
        userAdmin.setCreatedDate(Instant.now());
        userAdmin.setSchool(schoolDTO);
        userAdmin.setRoleUser(roleUserADMIN);
        userAdmin.setDisable(true);
        userDTOList.add(userAdmin);


        return userDTOList;

    }

}
