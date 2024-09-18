package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/settings")
@Slf4j
@RequiredArgsConstructor
public class AppSettingResource {

    private final AppSettingService appSettingService;

    @PostMapping
    public ResponseEntity<AppSettingDTO> save(@RequestBody AppSettingDTO appSettingDTO) {
        log.debug("REST Request to save AppSetting : {}", appSettingDTO);

        return new ResponseEntity<>(appSettingService.saveAppSettingDTO(appSettingDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        log.debug("REST Request to get all AppSettings");

        List<AppSettingDTO> appSettingDTOS = appSettingService.findAll();

        if (appSettingDTOS.isEmpty()) {
            return new ResponseEntity<>("Aucun Parametrage trouver", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(appSettingDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.debug("REST Request to get AppSetting : {}", id);

        Optional<AppSettingDTO> appSettingDTO = appSettingService.findById(id);

        if (appSettingDTO.isPresent()) {
            return new ResponseEntity<>(appSettingDTO.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Aucun Parametrage trouver By Id", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> findBySlug(@PathVariable String slug) {
        log.debug("REST Request to get AppSetting : {}", slug);

        Optional<AppSettingDTO> settingDTO = appSettingService.findBySlug(slug);
        if (settingDTO.isPresent()) {
            return new ResponseEntity<>(settingDTO.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Aucun Parametrage trouver : By Slug", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.debug("REST Request to delete AppSetting : {}", id);
        appSettingService.deleteById(id);
    }

    @PutMapping("/{id}")
    public AppSettingDTO update(@PathVariable Long id, @RequestBody AppSettingDTO appSettingDTO) {
        log.debug("REST Request to update AppSetting : {}", id);

        return appSettingService.update(appSettingDTO, id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id, @RequestBody AppSettingDTO appSettingDTO) {
        log.debug("REST Request to patch AppSetting : {}", id);

        Optional<AppSettingDTO> settingDTO = appSettingService.findById(id);
        if (settingDTO.isPresent()) {
            return new ResponseEntity<>(appSettingService.partialUpdate(appSettingDTO, id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Setting not found", HttpStatus.NO_CONTENT);
    }
}
