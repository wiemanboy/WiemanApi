package com.wiemanboy.wiemanapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SkillSection {
    @Setter
    private String locale;
    @Setter
    private String title;
    List<Skill> skills = new ArrayList<>();

    public SkillSection(String locale, String title) {
        this.locale = locale;
        this.title = title;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        this.skills.remove(skill);
    }
}
