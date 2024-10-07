package com.wiemanboy.wiemanapi.presentation;

import com.wiemanboy.wiemanapi.application.ProfileService;
import com.wiemanboy.wiemanapi.presentation.dto.response.ProfileDto;
import com.wiemanboy.wiemanapi.presentation.dto.response.ProfileLocaleDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/test/")
    public String getTest(@CookieValue(value = "token") String testCookie) {
        return "Cookie value: " + testCookie;
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
