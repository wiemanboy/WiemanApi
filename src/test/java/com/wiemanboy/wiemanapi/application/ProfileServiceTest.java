package com.wiemanboy.wiemanapi.application;

import com.wiemanboy.wiemanapi.data.ProfileRepository;
import com.wiemanboy.wiemanapi.domain.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        Profile profile = new Profile("John", "Doe", "johndoe");
        when(profileRepository.findById("")).thenReturn(Optional.of(profile));

        Profile result = profileService.getProfile("");
        assertEquals(profile, result);
    }

    @Test
    void testGetProfileByName() {
        String name = "johndoe";
        Profile profile = new Profile("John", "Doe", "johndoe");
        when(profileRepository.findByFullNameOrUsername(name)).thenReturn(Optional.of(profile));

        Profile result = profileService.getProfileByName(name);
        assertEquals(profile, result);
    }

    @Test
    void testCreateProfile() {
        Profile profile = new Profile("John", "Doe", "johndoe");
        when(profileRepository.save(any(Profile.class))).thenReturn(profile);

        Profile result = profileService.createProfile("John", "Doe", "johndoe");
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
}