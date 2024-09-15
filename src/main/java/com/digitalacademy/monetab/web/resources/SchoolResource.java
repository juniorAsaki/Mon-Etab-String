package com.digitalacademy.monetab.web.resources;

import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schools")
@Slf4j
@RequiredArgsConstructor
public class SchoolResource {
    private final SchoolService schoolService;
    private final AppSettingService appSettingService;

    @PostMapping
    public ResponseEntity<?> saveSchool(@RequestBody SchoolDTO schoolDTO) {
        log.debug("REST request to save School: {}", schoolDTO);

        Optional<AppSettingDTO> setting = appSettingService.findById(schoolDTO.getAppSetting().getId_appsetting());

        if (setting.isPresent()) {
            schoolDTO.setAppSetting(setting.get());
            return ResponseEntity.ok(schoolService.saveSchool(schoolDTO));
        }
        return new ResponseEntity<>("Setting not found !", HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public List<SchoolDTO> getAllSchools() {
        log.debug("REST request to get a page of Schools");
        return schoolService.findAll();
    }

    @GetMapping("/{id}")
    public SchoolDTO getSchool(@PathVariable Long id) {
        log.debug("REST request to get School : {}", id);
        return schoolService.findOne(id).orElse(null);
    }

    @GetMapping("/slug/{slug}")
    public SchoolDTO getSchoolBySlug(@PathVariable String slug) {
        log.debug("REST request to get School by slug : {}", slug);
        return schoolService.findBySlug(slug).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        log.debug("REST request to delete School : {}", id);
        schoolService.delete(id);
    }

    @PutMapping("/{id}")
    public SchoolDTO updateSchool(@PathVariable Long id, @RequestBody SchoolDTO schoolDTO) {
        log.debug("REST request to update School : {}", id);
        return schoolService.update(schoolDTO, id);
    }
}
