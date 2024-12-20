package com.wiemanboy.wiemanapi.presentation;

import com.wiemanboy.wiemanapi.application.ProfileService;
import com.wiemanboy.wiemanapi.presentation.dto.request.CreateProfileDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.ProfileDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.ProfileLocaleDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ProfileDto getProfile(@PathVariable String id) {
        return ProfileDto.from(profileService.getProfile(id));
    }

    @GetMapping("/{name}/{locale}")
    public ProfileLocaleDto getProfileByName(@PathVariable String name, @PathVariable String locale) {
        return ProfileLocaleDto.from(profileService.getProfileByName(name), locale);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDto createProfile(@RequestBody CreateProfileDto createProfileDto) {
        return ProfileDto.from(profileService.createProfile(
                createProfileDto.firstName(),
                createProfileDto.lastName(),
                createProfileDto.username(),
                createProfileDto.descriptions(),
                createProfileDto.socials(),
                createProfileDto.skillSections()
        ));
    }

    @PutMapping("/{id}")
    public ProfileDto updateProfile(@PathVariable String id, @RequestBody CreateProfileDto createProfileDto) {
        return ProfileDto.from(profileService.updateProfile(
                id,
                createProfileDto.firstName(),
                createProfileDto.lastName(),
                createProfileDto.username(),
                createProfileDto.descriptions(),
                createProfileDto.socials(),
                createProfileDto.skillSections()
        ));
    }
}
