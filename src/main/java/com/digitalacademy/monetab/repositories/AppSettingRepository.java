package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.AppSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppSettingRepository extends JpaRepository<AppSetting, Long> {
    Optional<AppSetting> findAppSettingBySlug(String slug);
}
