package com.wiemanboy.wiemanapi.domain.exceptions;

import lombok.Getter;

@Getter
public class ProfileNotFoundException extends RuntimeException {

    private final String id;
    private final String name;

    public ProfileNotFoundException(String id, String name) {
        super("Profile not found");
        this.id = id;
        this.name = name;
    }
}
