package com.wiemanboy.wiemanapi.builders;

import com.wiemanboy.wiemanapi.domain.Profile;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class ProfileBuilder {
    private String firstName = "John";
    private String lastName = "Doe";
    private String username = "johndoe";

    public Profile build() {
        return new Profile(firstName, lastName, username);
    }
}
