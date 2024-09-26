package com.wiemanboy.wiemanapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@Document
public class Profile {
    private String id;
    private List<Description> descriptions = new ArrayList<>();
    private List<Social> socials = new ArrayList<>();
    private List<SkillSection> skillSections = new ArrayList<>();
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String username;

    public Profile(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    protected Profile() {
    }

    protected Profile(List<Description> descriptions, List<Social> socials, List<SkillSection> skillSections, String firstName, String lastName, String username) {
        this.descriptions = descriptions;
        this.socials = socials;
        this.skillSections = skillSections;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public void addDescription(Description description) {
        this.descriptions.add(description);
    }

    public Description getDescription(String locale) {
        return descriptions.stream()
                .filter(description -> description.getLocale().equals(locale))
                .findFirst()
                .orElse(null);
    }

    public void removeDescription(Description description) {
        this.descriptions.remove(description);
    }

    public void addSocial(Social social) {
        socials.add(social);
    }

    public void removeSocial(Social social) {
        socials.remove(social);
    }

    public void addSkillSection(SkillSection skillSection) {
        skillSections.add(skillSection);
    }

    public List<SkillSection> getSkillSections(String locale) {
        return skillSections.stream()
                .filter(skillSection -> skillSection.getLocale().equals(locale))
                .toList();
    }

    public void removeSkillSection(SkillSection skillSection) {
        skillSections.remove(skillSection);
    }
}
