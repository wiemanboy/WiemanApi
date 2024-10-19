package com.wiemanboy.wiemanapi.domain.exceptions;

import lombok.Getter;

import static java.lang.String.format;

@Getter
public class InvalidSkillLevelException extends RuntimeException {

    private final int min;
    private final int max;

    public InvalidSkillLevelException(int min, int max) {
        super(format("Level must be between %d and %d", min, max));
        this.min = min;
        this.max = max;
    }
}
