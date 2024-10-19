package com.wiemanboy.wiemanapi.domain;

import com.wiemanboy.wiemanapi.domain.exceptions.InvalidSkillLevelException;
import lombok.Value;

@Value
public class SkillLevel {
    int value;

    private SkillLevel(int value) {
        this.value = value;
    }

    public static SkillLevel of(int value) {
        if (value < 0 || value > 5) {
            throw new InvalidSkillLevelException(0, 5);
        }
        return new SkillLevel(value);
    }
}
