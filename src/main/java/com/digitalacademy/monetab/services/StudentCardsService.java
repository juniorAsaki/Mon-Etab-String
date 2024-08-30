package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.StudentCardsDTO;

import java.util.Set;

public interface StudentCardsService {

    StudentCardsDTO findById(Long id);
    Set<StudentCardsDTO> findAll();
    StudentCardsDTO save(StudentCardsDTO studentCardsDTO);
    StudentCardsDTO update(StudentCardsDTO studentCardsDTO);
    void delete(StudentCardsDTO studentCardsDTO);
}
