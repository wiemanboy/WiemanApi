package com.wiemanboy.wiemanapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Skill {
    private String name;
    private SkillLevel level;

    public Skill(String name, SkillLevel level) {
        this.name = name;
        this.level = level;
    }

}
