package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    Optional<Absence> findAbsenceBySlug(String slug);
}
