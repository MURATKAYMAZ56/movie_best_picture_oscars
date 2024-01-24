package com.intake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AwardCategory {
    BEST_PICTURE("Best Picture");

    private final String value;
}
