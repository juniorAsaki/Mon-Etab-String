package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.StudentCardsRepository;
import com.digitalacademy.monetab.services.StudentCardsService;
import com.digitalacademy.monetab.services.dto.StudentCardsDTO;
import com.digitalacademy.monetab.services.mapper.StudentCardsMapper;
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
public class StudentCardsServiceImpl implements StudentCardsService {

    private final StudentCardsRepository studentCardsRepository;
    private final StudentCardsMapper studentCardsMapper;

    @Override
    public StudentCardsDTO findById(Long id) {
        return studentCardsRepository.findById(id).map(studentCards -> studentCardsMapper.ToDto(studentCards)).orElse(null);
    }

    @Override
    public Optional<StudentCardsDTO> findBySlug(String slug) {
        return studentCardsRepository.findBySlug(slug).map(studentCardsMapper::ToDto);
    }

    @Override
    public List<StudentCardsDTO> findAll() {
        return studentCardsRepository.findAll().stream().map(studentCards -> studentCardsMapper.ToDto(studentCards)).toList();
    }

    @Override
    public StudentCardsDTO save(StudentCardsDTO studentCardsDTO) {
        return studentCardsMapper.ToDto(studentCardsRepository.save(studentCardsMapper.DtoToEntity(studentCardsDTO)));
    }

    @Override
    public StudentCardsDTO saveStudentCards(StudentCardsDTO studentCardsDTO) {
        final String SLUG = SlugGifyUtils.generateSlug(studentCardsDTO.getReference());
        studentCardsDTO.setSlug(SLUG);
        return save(studentCardsDTO);
    }

    @Override
    public StudentCardsDTO update(StudentCardsDTO studentCardsDTO) {
        return studentCardsRepository.findById(studentCardsDTO.getIdStudentCard()).map(studentCards -> {
            studentCards.setReference(studentCardsDTO.getReference());
            return save(studentCardsDTO);
        }).orElseThrow(() -> new RuntimeException("Student Cards Not Found"));
    }

    @Override
    public StudentCardsDTO update(StudentCardsDTO studentCardsDTO, Long id) {
        studentCardsDTO.setIdStudentCard(id);
        return update(studentCardsDTO);
    }

    @Override
    public void delete(Long id) {
        studentCardsRepository.deleteById(id);
    }
}
