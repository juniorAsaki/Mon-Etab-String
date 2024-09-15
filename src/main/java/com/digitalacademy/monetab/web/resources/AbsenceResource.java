package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.AbsenceService;
import com.digitalacademy.monetab.services.dto.AbsenceDTO;
import com.digitalacademy.monetab.services.mapper.AbsenceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/absences")
@Slf4j
@RequiredArgsConstructor
public class AbsenceResource {

    private final AbsenceService absenceService;
    private final AbsenceMapper absenceMapper;


    @PostMapping
    public ResponseEntity<AbsenceDTO> saveAbsence(@RequestBody AbsenceDTO absence) {
        log.debug("REST request to save Absence: {}", absence);
        return new ResponseEntity<>(absenceService.saveAbsence(absence), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public AbsenceDTO updateAbsence(@RequestBody AbsenceDTO absence, @PathVariable Long id) {
        log.debug("REST request to update Absence : {}", absence);
        return absenceService.update(absence, id);
    }

    @GetMapping
    public List<AbsenceDTO> getAllAbsences() {
        log.debug("REST request to get all Absences");
        return absenceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAbsenceById(@PathVariable Long id) {
        log.debug("REST request to get Absence : {}", id);

        AbsenceDTO absenceDTO = absenceService.findById(id).orElse(null);

        if (absenceDTO == null) {
            return new ResponseEntity<>("Absence not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(absenceDTO, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAbsenceById(@PathVariable Long id) {
        log.debug("REST request to delete Absence : {}", id);

        absenceService.deleteById(id);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateAbsence(@PathVariable Long id, @RequestBody AbsenceDTO absenceDTO) {
        log.debug("REST request to partial update Absence : {}", absenceDTO);

        Optional<AbsenceDTO> optionalAbsenceDTO = absenceService.findById(id);
        if (optionalAbsenceDTO.isPresent()) {
            return new ResponseEntity<>(absenceService.partialUpdate(absenceDTO, id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Absence not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getAbsenceBySlug(@PathVariable String slug) {
        log.debug("REST request to get Absence by slug : {}", slug);
        return null;
    }


}
