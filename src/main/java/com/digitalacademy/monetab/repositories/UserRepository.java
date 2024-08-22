package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
