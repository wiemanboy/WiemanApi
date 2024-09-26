package com.wiemanboy.wiemanapi.presentation.dto.response;

import com.wiemanboy.wiemanapi.domain.SkillSection;

import java.util.List;

public record SkillSectionDto(
        String locale,
        String title,
        List<SkillDto> skills
) {
    public static SkillSectionDto from(SkillSection skillSection) {
        return new SkillSectionDto(skillSection.getLocale(), skillSection.getTitle(), SkillDto.from(skillSection.getSkills()));
    }

    public static List<SkillSectionDto> from(List<SkillSection> skillSections) {
        return skillSections.stream().map(SkillSectionDto::from).toList();
    }
}
