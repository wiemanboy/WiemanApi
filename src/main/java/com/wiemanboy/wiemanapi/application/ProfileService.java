package com.wiemanboy.wiemanapi.application;

import com.wiemanboy.wiemanapi.data.ProfileRepository;
import com.wiemanboy.wiemanapi.domain.Profile;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile getProfile(UUID id) {
        return profileRepository.findById(id).orElseThrow();
    }

    public Profile getProfileByName(String name) {
        return profileRepository.findByFullNameOrUsername(name).orElseThrow();
    }

    public Profile createProfile(String firstName, String lastName, String username) {
        Profile profile = new Profile(firstName, lastName, username);
        return profileRepository.save(profile);
    }
}
