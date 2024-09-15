package com.digitalacademy.monetab.web.resources;

import com.digitalacademy.monetab.services.RoleUserService;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.UserService;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import com.digitalacademy.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;
    private final SchoolService schoolService;
    private final RoleUserService roleUserService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        log.debug("REST request to save User : {}", userDTO);

        AtomicInteger temp = new AtomicInteger();
        Optional<SchoolDTO> school = schoolService.findOne(userDTO.getSchool().getId_school());

//        List<RoleUserDTO> roles = roleUserService.findAll().stream().map(role -> {
//
//                return role.getIdRoleUser().equals(userDTO.getRoleUser().get(temp.get()).getIdRoleUser()) ?: role;
//
//            temp.getAndIncrement();
//            return null;
//        });

        if (school.isPresent()) {
            userDTO.setSchool(school.get());
        }
//        userDTO.setRoleUser(roles);
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        log.debug("REST request to get all Users");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getOneUser(@PathVariable Long id) {
        log.debug("REST request to get User : {}", id);
        return userService.findById(id).orElse(null);
    }

    @GetMapping("/slug/{slug}")
    public UserDTO getOneUserSlug(@PathVariable String slug) {
        log.debug("REST request to get User : {}", slug);

        return userService.findBySlug(slug).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.debug("REST request to delete User : {}", id);
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        log.debug("REST request to update User : {} = {}", id, userDTO);

        return userService.update(userDTO, id);
    }
}
