package com.wiemanboy.wiemanapi.presentation;

import com.wiemanboy.wiemanapi.application.ProfileService;
import com.wiemanboy.wiemanapi.presentation.dto.response.ProfileDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.ProfileLocaleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
