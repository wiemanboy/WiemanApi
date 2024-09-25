package com.wiemanboy.wiemanapi.builders;

import com.wiemanboy.wiemanapi.domain.Social;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.net.URI;

@Setter
@Accessors(chain = true)
public class SocialBuilder {
    private String username = "johndoe";
    private String platform = "LinkedIn";
    private URI url = URI.create("https://www.linkedin.com/in/johndoe");

    public SocialBuilder setUrl(String url) {
        this.url = URI.create(url);
        return this;
    }

    public Social build() {
        return new Social(username, platform, url);
    }
}
