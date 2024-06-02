package org.example.renovatioapi.dao;

import org.example.renovatioapi.model.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserSettingsRepository extends JpaRepository<UserSettings, Long> {
    Optional<UserSettings> findByUserUuid(String userUuid);
}
