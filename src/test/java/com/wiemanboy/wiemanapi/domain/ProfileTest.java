package com.wiemanboy.wiemanapi.domain;

import com.wiemanboy.wiemanapi.builders.DescriptionBuilder;
import com.wiemanboy.wiemanapi.builders.ProfileBuilder;
import com.wiemanboy.wiemanapi.builders.SkillSectionBuilder;
import com.wiemanboy.wiemanapi.builders.SocialBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileTest {

    @Test
    void testAddDescription() {
        Profile profile = (new ProfileBuilder()).build();
        Description description = (new DescriptionBuilder()).build();
        profile.addDescription(description);
        assertEquals(1, profile.getDescriptions().size());
    }

    @Test
    void testGetDescription() {
        Profile profile = (new ProfileBuilder()).build();
        Description description = (new DescriptionBuilder()).setLocale("en").build();
        profile.addDescription(description);
        profile.addDescription((new DescriptionBuilder()).setLocale("nl").build());

        assertEquals(description, profile.getDescription("en"));
    }

    @Test
    void testRemoveDescription() {
        Profile profile = (new ProfileBuilder()).build();
        Description description = (new DescriptionBuilder()).build();
        profile.addDescription(description);
        profile.removeDescription(description);
        assertEquals(0, profile.getDescriptions().size());
    }

    @Test
    void testAddSocial() {
        Profile profile = (new ProfileBuilder()).build();
        Social social = (new SocialBuilder()).build();
        profile.addSocial(social);
        assertEquals(1, profile.getSocials().size());
    }

    @Test
    void testRemoveSocial() {
        Profile profile = (new ProfileBuilder()).build();
        Social social = (new SocialBuilder()).build();
        profile.addSocial(social);
        profile.removeSocial(social);
        assertEquals(0, profile.getSocials().size());
    }

    @Test
    void testAddSkillSection() {
        Profile profile = (new ProfileBuilder()).build();
        SkillSection skillSection = (new SkillSectionBuilder()).build();
        profile.addSkillSection(skillSection);
        assertEquals(1, profile.getSkillSections().size());
    }

    @Test
    void testGetSkillSections() {
        Profile profile = (new ProfileBuilder()).build();
        SkillSection skillSection = (new SkillSectionBuilder()).setLocale("en").build();
        profile.addSkillSection(skillSection);
        profile.addSkillSection((new SkillSectionBuilder()).setLocale("nl").build());

        assertEquals(skillSection, profile.getSkillSections("en").getFirst());
    }

    @Test
    void testRemoveSkillSection() {
        Profile profile = (new ProfileBuilder()).build();
        SkillSection skillSection = (new SkillSectionBuilder()).build();
        profile.addSkillSection(skillSection);
        profile.removeSkillSection(skillSection);
        assertEquals(0, profile.getSkillSections().size());
    }
}