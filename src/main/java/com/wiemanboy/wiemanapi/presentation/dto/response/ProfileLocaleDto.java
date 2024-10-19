package com.wiemanboy.wiemanapi.presentation.dto.response;

import com.wiemanboy.wiemanapi.domain.Description;
import com.wiemanboy.wiemanapi.domain.Profile;

import java.util.List;

public record ProfileLocaleDto(
        String id,
        String firstName,
        String lastName,
        String username,
        Description description,
        List<SkillSectionDto> skillSections,
        List<SocialDto> socials
) {
    public static ProfileLocaleDto from(Profile profile, String locale) {
        return new ProfileLocaleDto(
                profile.getId(),
                profile.getFirstName(),
                profile.getLastName(),
                profile.getUsername(),
                profile.getDescription(locale),
                SkillSectionDto.from(profile.getSkillSections(locale)),
                SocialDto.from(profile.getSocials())
        );
    }
}
