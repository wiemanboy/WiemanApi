package com.wiemanboy.wiemanapi.domain;

import com.wiemanboy.wiemanapi.builders.SkillBuilder;
import com.wiemanboy.wiemanapi.builders.SkillSectionBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkillSectionTest {

    @Test
    void testAddSkill() {
        SkillSection skillSection = (new SkillSectionBuilder()).build();
        Skill skill = (new SkillBuilder()).build();
        skillSection.addSkill(skill);
        assertEquals(1, skillSection.getSkills().size());
    }

    @Test
    void testRemoveSkill() {
        SkillSection skillSection = (new SkillSectionBuilder()).build();
        Skill skill = (new SkillBuilder()).build();
        skillSection.addSkill(skill);
        skillSection.removeSkill(skill);
        assertEquals(0, skillSection.getSkills().size());
    }

}