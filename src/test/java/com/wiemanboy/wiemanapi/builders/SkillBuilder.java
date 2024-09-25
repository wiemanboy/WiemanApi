package com.wiemanboy.wiemanapi.builders;

import com.wiemanboy.wiemanapi.domain.Skill;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class SkillBuilder {
    private String name = "Skill";
    private String description = "Description";

    public Skill build() {
        return new Skill(name, description);
    }
}
