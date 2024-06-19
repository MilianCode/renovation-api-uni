package org.example.renovatioapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.renovatioapi.model.UserSettings;
import org.example.renovatioapi.service.UserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/settings")
public class UserSettingsController {
    @Autowired
    private UserSettingsService service;

    @GetMapping()
    public ResponseEntity<UserSettings> getUserSettings(HttpServletRequest request, HttpServletResponse response) {
        String userUuid = getUserUuidFromCookies(request, response);

        Optional<UserSettings> settings = service.getUserSettingsByUuid(userUuid);
        return settings.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public UserSettings saveUserSettings(HttpServletRequest request, HttpServletResponse response, @RequestBody UserSettings settings) {
        String userUuid = getUserUuidFromCookies(request, response);
        settings.setUserUuid(userUuid);
        return service.save(settings);
    }

    private String getUserUuidFromCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user_uuid".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        String userUuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("user_uuid", userUuid);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(cookie);
        return userUuid;
    }
}
