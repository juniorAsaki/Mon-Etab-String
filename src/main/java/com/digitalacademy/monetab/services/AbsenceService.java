package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.AbsenceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AbsenceService {

    Optional<AbsenceDTO> findById(Long id);

    Optional<AbsenceDTO> findBySlug(String slug);

    List<AbsenceDTO> findAll();

    AbsenceDTO save(AbsenceDTO absenceDTO);

    AbsenceDTO update(AbsenceDTO absenceDTO);

    AbsenceDTO update(AbsenceDTO absenceDTO, Long id);

    void deleteById(Long id);

    AbsenceDTO saveAbsence(AbsenceDTO absence);

    AbsenceDTO partialUpdate(AbsenceDTO absence, Long id);
}
