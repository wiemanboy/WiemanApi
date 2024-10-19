package com.wiemanboy.wiemanapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Description {
    private String locale;
    private String title;
    private String content;

    public Description(String locale, String title, String content) {
        this.locale = locale;
        this.title = title;
        this.content = content;
    }
}
