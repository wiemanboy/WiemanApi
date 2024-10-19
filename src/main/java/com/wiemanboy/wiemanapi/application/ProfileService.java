package com.wiemanboy.wiemanapi.application;

import com.wiemanboy.wiemanapi.data.ProfileRepository;
import com.wiemanboy.wiemanapi.domain.*;
import com.wiemanboy.wiemanapi.domain.exceptions.ProfileNotFoundException;
import com.wiemanboy.wiemanapi.presentation.dto.response.DescriptionDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.SkillSectionDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.SocialDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile getProfile(String id) {
        return profileRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException(id, null));
    }

    public Profile getProfileByName(String name) {
        return profileRepository.findByFullNameOrUsername(name).orElseThrow(() -> new ProfileNotFoundException(null, name));
    }

    public Profile createProfile(String firstName, String lastName, String username, List<DescriptionDto> descriptionDtos, List<SocialDto> socialDtos, List<SkillSectionDto> skillSectionDtos) {
        Profile profile = new Profile(
                firstName,
                lastName,
                username,
                descriptionDtos.stream().map(
                        descriptionDto -> Description.builder()
                                .title(descriptionDto.title())
                                .locale(descriptionDto.locale())
                                .content(descriptionDto.content())
                                .build()
                ).toList(),
                socialDtos.stream().map(
                        socialDto -> Social.builder()
                                .username(socialDto.username())
                                .platform(socialDto.platform())
                                .url(URI.create(socialDto.url()))
                                .build()
                ).toList(),
                skillSectionDtos.stream().map(
                        skillSectionDto -> SkillSection.builder()
                                .title(skillSectionDto.title())
                                .locale(skillSectionDto.locale())
                                .skills(skillSectionDto.skills().stream()
                                        .map(
                                                skillDto -> Skill.builder()
                                                        .name(skillDto.name())
                                                        .level(SkillLevel.of(skillDto.level()))
                                                        .build()
                                        ).toList()
                                ).build(
                                )
                ).toList()
        );
        return profileRepository.save(profile);
    }

    public Profile updateProfile(String id, String firstName, String lastName, String username, List<DescriptionDto> descriptionDtos, List<SocialDto> socialDtos, List<SkillSectionDto> skillSectionDtos) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException(id, null));

        if (firstName != null) {
            profile.setFirstName(firstName);
        }
        if (lastName != null) {
            profile.setLastName(lastName);
        }
        if (username != null) {
            profile.setUsername(username);
        }
        if (descriptionDtos != null) {
            profile.setDescriptions(
                    descriptionDtos.stream().map(
                            descriptionDto -> Description.builder()
                                    .title(descriptionDto.title())
                                    .locale(descriptionDto.locale())
                                    .content(descriptionDto.content())
                                    .build()
                    ).toList()
            );
        }
        if (socialDtos != null) {
            profile.setSocials(
                    socialDtos.stream().map(
                            socialDto -> Social.builder()
                                    .username(socialDto.username())
                                    .platform(socialDto.platform())
                                    .url(URI.create(socialDto.url()))
                                    .build()
                    ).toList()
            );
        }
        if (skillSectionDtos != null) {
            profile.setSkillSections(
                    skillSectionDtos.stream().map(
                            skillSectionDto -> SkillSection.builder()
                                    .title(skillSectionDto.title())
                                    .locale(skillSectionDto.locale())
                                    .skills(skillSectionDto.skills().stream()
                                            .map(
                                                    skillDto -> Skill.builder()
                                                            .name(skillDto.name())
                                                            .level(SkillLevel.of(skillDto.level()))
                                                            .build()
                                            ).toList()
                                    ).build(
                                    )
                    ).toList()
            );
        }

        return profileRepository.save(profile);
    }
}
