package com.wiemanboy.wiemanapi.presentation.dto.response;

import com.wiemanboy.wiemanapi.domain.Social;

import java.util.List;

public record SocialDto(
        String username,
        String platform,
        String url
) {
    public static SocialDto from(Social social) {
        return new SocialDto(social.getUsername(), social.getPlatform(), social.getUrl().toString());
    }

    public static List<SocialDto> from(List<Social> socials) {
        return socials.stream().map(SocialDto::from).toList();
    }
}
