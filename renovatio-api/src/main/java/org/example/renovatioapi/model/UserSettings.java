package org.example.renovatioapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userUuid;
    private boolean invertColors;
    private boolean whiteBlackFilter;
    @Enumerated(EnumType.STRING)
    private FontSize fontSize;

    public enum FontSize {
        S, M, L, XL
    }

}
