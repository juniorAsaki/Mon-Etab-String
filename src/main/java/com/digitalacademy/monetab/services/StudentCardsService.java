package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.StudentCardsDTO;

import java.util.List;
import java.util.Set;

public interface StudentCardsService {

    StudentCardsDTO findById(Long id);

    List<StudentCardsDTO> findAll();

    StudentCardsDTO save(StudentCardsDTO studentCardsDTO);

    StudentCardsDTO update(StudentCardsDTO studentCardsDTO);

    void delete(Long id);
}
