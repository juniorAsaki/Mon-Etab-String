package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
