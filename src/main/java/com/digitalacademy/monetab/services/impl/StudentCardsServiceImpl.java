package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.StudentCardsRepository;
import com.digitalacademy.monetab.services.StudentCardsService;
import com.digitalacademy.monetab.services.dto.StudentCardsDTO;
import com.digitalacademy.monetab.services.mapper.StudentCardsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class StudentCardsServiceImpl implements StudentCardsService {

    private final StudentCardsRepository studentCardsRepository;
    private final StudentCardsMapper studentCardsMapper;

    @Override
    public StudentCardsDTO findById(Long id) {
        return studentCardsRepository.findById(id).map(studentCards -> studentCardsMapper.ToDto(studentCards)).orElse(null);
    }

    @Override
    public Set<StudentCardsDTO> findAll() {
        return (Set<StudentCardsDTO>) studentCardsRepository.findAll().stream().map(studentCards -> studentCardsMapper.ToDto(studentCards));
    }

    @Override
    public StudentCardsDTO save(StudentCardsDTO studentCardsDTO) {
        return studentCardsMapper.ToDto(studentCardsRepository.save(studentCardsMapper.DtoToEntity(studentCardsDTO)));
    }

    @Override
    public StudentCardsDTO update(StudentCardsDTO studentCardsDTO) {
        return save(studentCardsDTO);
    }

    @Override
    public void delete(StudentCardsDTO studentCardsDTO) {
        studentCardsRepository.delete(studentCardsMapper.DtoToEntity(studentCardsDTO));
    }
}
