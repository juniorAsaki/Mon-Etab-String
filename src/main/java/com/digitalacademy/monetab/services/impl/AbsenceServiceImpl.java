package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Absence;
import com.digitalacademy.monetab.repositories.AbsenceRepository;
import com.digitalacademy.monetab.services.AbsenceService;
import com.digitalacademy.monetab.services.Mapping.AbsenceMapping;
import com.digitalacademy.monetab.services.dto.AbsenceDTO;
import com.digitalacademy.monetab.services.mapper.AbsenceMapper;
import com.digitalacademy.monetab.utils.SlugGifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Optional<AbsenceDTO> findBySlug(String slug) {
        return absenceRepository.findAbsenceBySlug(slug).map(absenceMapper::ToDto);
    }

    @Override
    public List<AbsenceDTO> findAll() {
        return absenceRepository.findAll().stream().map(absence -> absenceMapper.ToDto(absence)).toList();
    }

    @Override
    public AbsenceDTO save(AbsenceDTO absenceDTO) {
        Absence absence = absenceMapper.DtoToEntity(absenceDTO);
        return absenceMapper.ToDto(absenceRepository.save(absence));
    }

    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO) {
        return findById(absenceDTO.getId_absence()).map(existingAbsence -> {
            existingAbsence.setDateAbsence(absenceDTO.getDateAbsence());
            existingAbsence.setNumberAbsence(absenceDTO.getNumberAbsence());

            return save(existingAbsence);
        }).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO, Long id) {
        absenceDTO.setId_absence(id);
        return update(absenceDTO);
    }

    @Override
    public void deleteById(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public AbsenceDTO saveAbsence(AbsenceDTO absence) {
        final String SLUG = SlugGifyUtils.generateSlug(absence.getNumberAbsence().toString());
        absence.setSlug(SLUG);
        return save(absence);
    }

    @Override
    public AbsenceDTO partialUpdate(AbsenceDTO absenceDTO, Long id) {
        return absenceRepository.findById(id).map(absence -> {
            AbsenceMapping.partialUpdate(absence, absenceDTO);
            return absence;
        }).map(absenceRepository::save).map(absenceMapper::ToDto).orElse(null);
    }
}
