package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.StudentCardsDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentCardsService {

    StudentCardsDTO findById(Long id);

    Optional<StudentCardsDTO> findBySlug(String slug);

    List<StudentCardsDTO> findAll();

    StudentCardsDTO save(StudentCardsDTO studentCardsDTO);

    StudentCardsDTO saveStudentCards(StudentCardsDTO studentCardsDTO);

    StudentCardsDTO update(StudentCardsDTO studentCardsDTO);

    StudentCardsDTO update(StudentCardsDTO studentCardsDTO, Long id);

    void delete(Long id);
}
