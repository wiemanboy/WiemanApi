package com.wiemanboy.wiemanapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
public class SkillSection {
    private String locale;
    private String title;
    @Builder.Default
    List<Skill> skills = new ArrayList<>();

    public SkillSection(String locale, String title, List<Skill> skills) {
        this.locale = locale;
        this.title = title;
        this.skills = skills;
    }
}
