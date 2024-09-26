package com.wiemanboy.wiemanapi.presentation.dto.response;

import com.wiemanboy.wiemanapi.domain.Description;

import java.util.List;

public record DescriptionDto(
        String locale,
        String title,
        String content
) {
    public static DescriptionDto from(Description description) {
        return new DescriptionDto(
                description.getLocale(),
                description.getTitle(),
                description.getContent());
    }

    public static List<DescriptionDto> from(List<Description> descriptions) {
        return descriptions.stream()
                .map(DescriptionDto::from)
                .toList();
    }
}
