package com.wiemanboy.wiemanapi.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@Document
@Setter
@Builder
public class Profile {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    @Builder.Default
    private List<Description> descriptions = new ArrayList<>();
    @Builder.Default
    private List<Social> socials = new ArrayList<>();
    @Builder.Default
    private List<SkillSection> skillSections = new ArrayList<>();

    protected Profile() {
    }

    protected Profile(String id, String firstName, String lastName, String username, List<Description> descriptions, List<Social> socials, List<SkillSection> skillSections) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.descriptions = descriptions;
        this.socials = socials;
        this.skillSections = skillSections;
    }

    public Profile(String firstName, String lastName, String username, List<Description> descriptions, List<Social> socials, List<SkillSection> skillSections) {
        this.descriptions = descriptions;
        this.socials = socials;
        this.skillSections = skillSections;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public Description getDescription(String locale) {
        return descriptions.stream()
                .filter(description -> description.getLocale().equals(locale))
                .findFirst()
                .orElse(null);
    }

    public List<SkillSection> getSkillSections(String locale) {
        return skillSections.stream()
                .filter(skillSection -> skillSection.getLocale().equals(locale))
                .toList();
    }
}
