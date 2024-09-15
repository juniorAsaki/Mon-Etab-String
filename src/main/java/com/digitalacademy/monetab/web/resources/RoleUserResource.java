package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.RoleUserService;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Slf4j
@RequiredArgsConstructor
public class RoleUserResource {
    private final RoleUserService roleUserService;

    @PostMapping
    public ResponseEntity<RoleUserDTO> saveRoles(@RequestBody RoleUserDTO roleUserDTO) {
        log.debug("REST request to save Roles : {}", roleUserDTO);
        return new ResponseEntity<>(roleUserService.saveRoleUser(roleUserDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoles(@PathVariable Long id) {
        log.debug("REST request to delete Roles : {}", id);
        roleUserService.delete(id);

        return new ResponseEntity<>("Role delete with success", HttpStatus.OK);
    }

    @GetMapping
    public List<RoleUserDTO> getAllRoles() {
        log.debug("REST request to get all Roles");
        return roleUserService.findAll();
    }

    @GetMapping("/{id}")
    public RoleUserDTO getRoles(@PathVariable Long id) {
        log.debug("REST request to get Roles : {}", id);

        return roleUserService.findById(id).orElse(null);
    }

    @GetMapping("/slug/{slug}")
    public RoleUserDTO getRolesBySlug(@PathVariable String slug) {
        log.debug("REST request to get Roles by slug : {}", slug);
        return roleUserService.findBySlug(slug).orElse(null);
    }

    @PutMapping("/{id}")
    public RoleUserDTO updateRoles(@PathVariable Long id, @RequestBody RoleUserDTO roleUserDTO) {
        log.debug("REST request to update Roles : {}", roleUserDTO);

        return roleUserService.update(roleUserDTO, id);
    }

}
