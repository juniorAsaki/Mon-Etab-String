package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
