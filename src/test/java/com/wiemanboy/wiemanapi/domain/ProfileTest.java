package com.wiemanboy.wiemanapi.domain;

import com.wiemanboy.wiemanapi.builders.DescriptionBuilder;
import com.wiemanboy.wiemanapi.builders.ProfileBuilder;
import com.wiemanboy.wiemanapi.builders.SkillSectionBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileTest {

    @Test
    void testGetDescription() {
        Profile profile = new ProfileBuilder().build();
        Description description = new DescriptionBuilder().setLocale("en").build();
        profile.setDescriptions(List.of(
                description,
                new DescriptionBuilder().setLocale("nl").build()
        ));
        assertEquals(description, profile.getDescription("en"));
    }

    @Test
    void testGetSkillSections() {
        Profile profile = (new ProfileBuilder()).build();
        SkillSection skillSection = (new SkillSectionBuilder()).setLocale("en").build();
        profile.setSkillSections(List.of(
                skillSection,
                new SkillSectionBuilder().setLocale("nl").build()
        ));
        assertEquals(skillSection, profile.getSkillSections("en").getFirst());
    }
}