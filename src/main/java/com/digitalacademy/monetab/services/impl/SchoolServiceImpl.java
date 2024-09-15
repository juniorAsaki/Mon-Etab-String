package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.SchoolRepository;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import com.digitalacademy.monetab.services.mapper.SchoolMapper;
import com.digitalacademy.monetab.utils.SlugGifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public SchoolDTO save(SchoolDTO schoolDTO) {
        return schoolMapper.ToDto(schoolRepository.save(schoolMapper.DtoToEntity(schoolDTO)));
    }

    @Override
    public SchoolDTO saveSchool(SchoolDTO schoolDTO) {
        final String SLUG = SlugGifyUtils.generateSlug(schoolDTO.getNameSchool());
        schoolDTO.setSlug(SLUG);
        return save(schoolDTO);
    }

    @Override
    public List<SchoolDTO> findAll() {
        return schoolRepository.findAll().stream().map(schoolMapper::ToDto).toList();
    }

    @Override
    public Optional<SchoolDTO> findOne(Long id) {
        return schoolRepository.findById(id).map(schoolMapper::ToDto);
    }

    @Override
    public Optional<SchoolDTO> findBySlug(String slug) {
        return schoolRepository.findBySlug(slug).map(schoolMapper::ToDto);
    }

    @Override
    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public SchoolDTO update(SchoolDTO schoolDTO) {
        return findOne(schoolDTO.getId_school()).map(schoolDTO1 -> {
            schoolDTO1.setNameSchool(schoolDTO.getNameSchool());
            return save(schoolDTO1);
        }).orElseThrow(() -> new RuntimeException("School not found"));
    }

    @Override
    public SchoolDTO update(SchoolDTO schoolDTO, Long id) {
        schoolDTO.setId_school(id);
        return update(schoolDTO);
    }

    @Override
    public SchoolDTO existingSchool() {
        log.debug("Request to check existing School");
        List<SchoolDTO> schoolDTOS = findAll();
        return schoolDTOS.stream().findFirst().orElse(null);
    }

    @Override
    public SchoolDTO initSchool(SchoolDTO schoolDTO) {
        log.debug("Request to initSchool {}", schoolDTO);
        SchoolDTO schoolDTO1 = existingSchool();
        if (schoolDTO1 == null) {
            return save(schoolDTO);
        }
        return schoolDTO1;
    }
}
