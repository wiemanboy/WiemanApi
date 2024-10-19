package com.wiemanboy.wiemanapi.builders;

import com.wiemanboy.wiemanapi.domain.Skill;
import com.wiemanboy.wiemanapi.domain.SkillLevel;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class SkillBuilder {
    private String name = "Skill";
    private int level = 5;

    public Skill build() {
        return new Skill(name, SkillLevel.of(level));
    }
}
