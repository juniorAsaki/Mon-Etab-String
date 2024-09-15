package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    Optional<School> findBySlug(String slug);
}
