package com.wiemanboy.wiemanapi.presentation.dto.response;

import com.wiemanboy.wiemanapi.domain.Profile;

public record ProfileDto(
        String id,
        String firstName,
        String lastName,
        String username
) {

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    public static ProfileDto from(Profile profile) {
        return new ProfileDto(
                profile.getId(),
                profile.getFirstName(),
                profile.getLastName(),
                profile.getUsername()
        );
    }
}
