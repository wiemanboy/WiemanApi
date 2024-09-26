package com.wiemanboy.wiemanapi.presentation.dto.response;

import com.wiemanboy.wiemanapi.domain.Profile;

import java.util.List;

public record ProfileDto(
        String id,
        String firstName,
        String lastName,
        String username,
        List<DescriptionDto> descriptions,
        List<SkillSectionDto> skillSections,
        List<SocialDto> socials
) {
    public static ProfileDto from(Profile profile) {
        return new ProfileDto(
                profile.getId(),
                profile.getFirstName(),
                profile.getLastName(),
                profile.getUsername(),
                DescriptionDto.from(profile.getDescriptions()),
                SkillSectionDto.from(profile.getSkillSections()),
                SocialDto.from(profile.getSocials())
        );
    }
}
