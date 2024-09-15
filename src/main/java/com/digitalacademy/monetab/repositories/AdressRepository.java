package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdressRepository extends JpaRepository<Adress, Long> {
    Optional<Adress> findBySlug(String slug);
}
