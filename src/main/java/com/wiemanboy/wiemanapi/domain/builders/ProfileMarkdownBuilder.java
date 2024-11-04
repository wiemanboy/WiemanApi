package com.wiemanboy.wiemanapi.domain.builders;

import com.wiemanboy.wiemanapi.domain.Skill;
import com.wiemanboy.wiemanapi.domain.SkillSection;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

import static java.lang.String.format;

@Setter
@Accessors(chain = true)
public class ProfileMarkdownBuilder {
    public String username;
    public String description;
    public List<SkillSection> skillSections;

    public String build() {
        return format("""
                        # Hi there, i'm %s!
                        %s
                        ## Skills
                        %s
                        Feel free to take a look at my projects and while you're at it, why not check out my website [wiemanboy.com](https://wiemanboy.com).
                        """,
                username,
                description,
                skillSections.stream().map(this::skillSection).reduce("", String::concat));
    }

    private String skillSection(SkillSection skillSection) {
        return format("""
                        ### %s
                        %s
                        """,
                skillSection.getTitle(),
                skillSection.getSkills().stream().map(this::skill).reduce("", String::concat));
    }

    private String skill(Skill skill) {
        return format("- ![](./icons/%s.svg) %s\n", skill.getName().toLowerCase().replace(" ", "_").replace(".", "_"), skill.getName());
    }
}
