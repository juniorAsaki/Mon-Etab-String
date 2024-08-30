package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.SchoolRepository;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import com.digitalacademy.monetab.services.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

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
    public Set<SchoolDTO> findAll() {
        return (Set<SchoolDTO>) schoolRepository.findAll().stream().map(school -> schoolMapper.ToDto(school)).toList();
    }

    @Override
    public SchoolDTO findOne(Long id) {
        return schoolRepository.findById(id).map(school -> schoolMapper.ToDto(school)).orElse(null);
    }

    @Override
    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public SchoolDTO update(SchoolDTO schoolDTO) {
        return schoolMapper.ToDto(schoolRepository.save(schoolMapper.DtoToEntity(schoolDTO)));
    }
}
