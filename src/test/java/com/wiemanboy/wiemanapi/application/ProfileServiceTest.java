package com.wiemanboy.wiemanapi.application;

import com.wiemanboy.wiemanapi.builders.DescriptionBuilder;
import com.wiemanboy.wiemanapi.builders.ProfileBuilder;
import com.wiemanboy.wiemanapi.builders.SkillSectionBuilder;
import com.wiemanboy.wiemanapi.builders.SocialBuilder;
import com.wiemanboy.wiemanapi.data.ProfileRepository;
import com.wiemanboy.wiemanapi.domain.Description;
import com.wiemanboy.wiemanapi.domain.Profile;
import com.wiemanboy.wiemanapi.domain.SkillSection;
import com.wiemanboy.wiemanapi.domain.Social;
import com.wiemanboy.wiemanapi.presentation.dto.response.DescriptionDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.SkillSectionDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.SocialDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProfileServiceTest {
    ProfileRepository profileRepository;
    ProfileService profileService;

    @BeforeEach
    void setUp() {
        profileRepository = Mockito.mock(ProfileRepository.class);
        profileService = new ProfileService(profileRepository);
    }

    @Test
    void testGetProfile() {
        Profile profile = new ProfileBuilder().build();
        when(profileRepository.findById("")).thenReturn(Optional.of(profile));

        Profile result = profileService.getProfile("");
        assertEquals(profile, result);
    }

    @Test
    void testGetProfileByName() {
        String name = "johndoe";
        Profile profile = new ProfileBuilder().setUsername(name).build();
        when(profileRepository.findByFullNameOrUsername(name)).thenReturn(Optional.of(profile));

        Profile result = profileService.getProfileByName(name);
        assertEquals(profile, result);
    }

    @Test
    void testCreateProfile() {
        Description description = new DescriptionBuilder().build();
        SkillSection skillSection = new SkillSectionBuilder().build();
        Social social = new SocialBuilder().build();
        Profile profile = Profile.builder()
                .firstName("John")
                .lastName("Doe")
                .username("johndoe")
                .descriptions(List.of(description))
                .socials(List.of(social))
                .skillSections(List.of(skillSection))
                .build();
        when(profileRepository.save(any(Profile.class))).thenReturn(profile);

        Profile result = profileService.createProfile(profile.getFirstName(), profile.getLastName(), profile.getUsername(), List.of(DescriptionDto.from(description)), List.of(SocialDto.from(social)), List.of(SkillSectionDto.from(skillSection)));
        assertEquals(profile, result);
    }

    @Test
    void testGetProfileNotFound() {
        when(profileRepository.findById("")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> profileService.getProfile(""));
    }

    @Test
    void testGetProfileByNameNotFound() {
        String name = "unknown";
        when(profileRepository.findByFullNameOrUsername(name)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> profileService.getProfileByName(name));
    }

    @Test
    void testUpdateProfile() {
        Profile profile = new ProfileBuilder().build();
        when(profileRepository.findById("")).thenReturn(Optional.of(profile));
        when(profileRepository.save(any(Profile.class))).thenReturn(profile);

        Profile result = profileService.updateProfile("", "Jane", null, null, null, null, null);
        assertEquals("Jane", result.getFirstName());
        assertEquals(profile.getLastName(), result.getLastName());
        assertEquals(profile.getUsername(), result.getUsername());
    }
}