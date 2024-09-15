package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    List<RoleUser> findByNameRole(String nameRole);

    Optional<RoleUser> findBySlug(String slug);
}
