package com.wiemanboy.wiemanapi.builders;

import com.wiemanboy.wiemanapi.domain.Description;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class DescriptionBuilder {
    private String locale = "en";
    private String title = "Title";
    private String content = "Content";

    public Description build() {
        return new Description(locale, title, content);
    }
}
