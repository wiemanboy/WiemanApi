package com.wiemanboy.wiemanapi.presentation.dto.request;

import com.wiemanboy.wiemanapi.presentation.dto.response.DescriptionDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.SkillSectionDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.SocialDto;

import java.util.List;

public record CreateProfileDto(
        String id,
        String firstName,
        String lastName,
        String username,
        List<DescriptionDto> descriptions,
        List<SkillSectionDto> skillSections,
        List<SocialDto> socials
) {
}
