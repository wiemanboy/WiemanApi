package com.wiemanboy.wiemanapi.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Document
public class Profile {
    private final List<Description> descriptions = new ArrayList<>();
    private final List<Social> socials = new ArrayList<>();
    private final List<SkillSection> skillSections = new ArrayList<>();
    @Id
    @GeneratedValue
    private UUID id;
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

    public void addDescription(Description description) {
        this.descriptions.add(description);
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

    public void removeSkillSection(SkillSection skillSection) {
        skillSections.remove(skillSection);
    }
}
