package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.AbsenceDTO;

import java.util.Optional;
import java.util.Set;

public interface AbsenceService {

    Optional<AbsenceDTO> findById(Long id);

    Set<AbsenceDTO> findAll();

    AbsenceDTO save(AbsenceDTO absenceDTO);

    AbsenceDTO update(AbsenceDTO absenceDTO);

    void deleteById(Long id);
}
