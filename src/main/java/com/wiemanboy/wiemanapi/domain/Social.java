package com.wiemanboy.wiemanapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;

@Getter
@Setter
@Builder
public class Social {
    private String username;
    private String platform;
    private URI url;

    public Social(String username, String platform, URI url) {
        this.username = username;
        this.platform = platform;
        this.url = url;
    }
}
