package com.digitalacademy.monetab.web.resources;

import com.digitalacademy.monetab.services.RoleUserService;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.UserService;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import com.digitalacademy.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

        // Récupérer les rôles associés à l'utilisateur
        List<RoleUserDTO> roles = userDTO.getRoleUser().stream().map(roleDTO -> roleUserService.findById(roleDTO.getIdRoleUser()).orElseThrow(() ->
                new RuntimeException("Role not found with id: " + roleDTO.getIdRoleUser()))).toList();

        if (school.isPresent()) {
            userDTO.setSchool(school.get());
        }
        userDTO.setRoleUser(roles);
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

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        log.debug("REST request to partial update User : {} = {}", id, userDTO);

        Optional<UserDTO> user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(userService.partialUpdate(userDTO, id), HttpStatus.OK);
        }

        return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
    }
}
