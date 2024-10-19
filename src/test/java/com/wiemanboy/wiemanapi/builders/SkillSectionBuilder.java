package com.wiemanboy.wiemanapi.builders;

import com.wiemanboy.wiemanapi.domain.SkillSection;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Accessors(chain = true)
public class SkillSectionBuilder {
    private String locale = "en";
    private String title = "Title";

    public SkillSection build() {
        return new SkillSection(locale, title, List.of());
    }
}
