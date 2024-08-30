package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.StudentCards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardsRepository extends JpaRepository<StudentCards, Long> {
}
