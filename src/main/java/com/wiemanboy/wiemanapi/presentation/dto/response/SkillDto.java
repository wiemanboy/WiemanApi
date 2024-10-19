package com.wiemanboy.wiemanapi.presentation.dto.response;

import com.wiemanboy.wiemanapi.domain.Skill;

import java.util.List;

public record SkillDto(
        String name,
        int level
) {
    public static SkillDto from(Skill skill) {
        return new SkillDto(skill.getName(), skill.getLevel().getValue());
    }

    public static List<SkillDto> from(List<Skill> skills) {
        return skills.stream().map(SkillDto::from).toList();
    }
}
