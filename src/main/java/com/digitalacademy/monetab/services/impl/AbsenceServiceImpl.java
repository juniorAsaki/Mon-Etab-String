package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Absence;
import com.digitalacademy.monetab.repositories.AbsenceRepository;
import com.digitalacademy.monetab.services.AbsenceService;
import com.digitalacademy.monetab.services.dto.AbsenceDTO;
import com.digitalacademy.monetab.services.mapper.AbsenceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final AbsenceMapper absenceMapper;

    @Override
    public Optional<AbsenceDTO> findById(Long id) {
        return absenceRepository.findById(id).map(absence -> absenceMapper.ToDto(absence));
    }

    @Override
    public Set<AbsenceDTO> findAll() {
        return (Set<AbsenceDTO>) absenceRepository.findAll().stream().map(absence -> absenceMapper.ToDto(absence)).toList();
    }

    @Override
    public AbsenceDTO save(AbsenceDTO absenceDTO) {
        Absence absence = absenceMapper.DtoToEntity(absenceDTO);
        return absenceMapper.ToDto(absenceRepository.save(absence));
    }

    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO) {
        Absence absence = absenceMapper.DtoToEntity(absenceDTO);
        absence = absenceRepository.save(absence);
        return absenceMapper.ToDto(absence);
    }

    @Override
    public void deleteById(Long id) {
        absenceRepository.deleteById(id);
    }
}
