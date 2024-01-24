package com.intake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WonStatus {
    YES("YES"),
    NO("NO");

    private final String value;
}
