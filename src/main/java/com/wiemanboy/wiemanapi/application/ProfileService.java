package com.wiemanboy.wiemanapi.application;

import com.wiemanboy.wiemanapi.data.ProfileRepository;
import com.wiemanboy.wiemanapi.domain.Profile;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile getProfile(String id) {
        return profileRepository.findById(id).orElseThrow();
    }

    public Profile getProfileByName(String name) {
        return profileRepository.findByFullNameOrUsername(name).orElseThrow();
    }

    public Profile createProfile(String firstName, String lastName, String username) {
        Profile profile = new Profile(firstName, lastName, username);
        return profileRepository.save(profile);
    }

    public Profile patchProfile(String id, String firstName, String lastName, String username) {
        Profile profile = profileRepository.findById(id).orElseThrow();

        if (firstName != null) {
            profile.setFirstName(firstName);
        }
        if (lastName != null) {
            profile.setLastName(lastName);
        }
        if (username != null) {
            profile.setUsername(username);
        }

        return profileRepository.save(profile);
    }
}
