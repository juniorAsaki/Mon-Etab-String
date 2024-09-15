package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.StudentCards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentCardsRepository extends JpaRepository<StudentCards, Long> {
    Optional<StudentCards> findBySlug(String slug);
}
