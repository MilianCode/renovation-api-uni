package org.example.renovatioapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.renovatioapi.dao.UserSettingsRepository;
import org.example.renovatioapi.model.UserSettings;
import org.example.renovatioapi.service.UserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSettingsServiceImpl implements UserSettingsService {
    @Autowired
    UserSettingsRepository userSettingsRepository;

    @Override
    public UserSettings save(UserSettings userSettings) {
        Optional<UserSettings> existingSettings = userSettingsRepository.findByUserUuid(userSettings.getUserUuid());
        if (existingSettings.isPresent()) {
            UserSettings existing = existingSettings.get();
            existing.setWhiteBlackFilter(userSettings.isWhiteBlackFilter());
            existing.setInvertColors(userSettings.isInvertColors());
            existing.setFontSize(userSettings.getFontSize());
            return userSettingsRepository.save(existing);
        } else {
            return userSettingsRepository.save(userSettings);
        }
    }

    public Optional<UserSettings> getUserSettingsByUuid(String userUuid) {
        return userSettingsRepository.findByUserUuid(userUuid);
    }

    @Override
    public UserSettings findById(Long id) {
        return userSettingsRepository.findById(id).orElse(null);
    }

    @Override
    public UserSettings update(UserSettings userSettings, Long id) {
        return userSettingsRepository.save(userSettings);
    }
}
