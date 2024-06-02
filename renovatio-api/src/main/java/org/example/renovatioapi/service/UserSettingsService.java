package org.example.renovatioapi.service;

import org.example.renovatioapi.model.UserSettings;

import java.util.Optional;

public interface UserSettingsService {
    UserSettings save(UserSettings userSettings);

    UserSettings findById(Long id);

    UserSettings update(UserSettings userSettings, Long id);

    Optional<UserSettings> getUserSettingsByUuid(String userUuid);

}
