package com.wiemanboy.wiemanapi.data;

import com.wiemanboy.wiemanapi.builders.ProfileBuilder;
import com.wiemanboy.wiemanapi.domain.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@EnabledIfEnvironmentVariable(named = "FUNCTIONAL_TESTING", matches = "true")
@DataMongoTest
class ProfileRepositoryTest {
    @Autowired
    private ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        profileRepository.deleteAll();
    }

    @ParameterizedTest
    @CsvSource({
            "John, Doe, doejohn, JohnDoe",
            "John, Doe, doejohn, johndoe",
            "john, doe, doejohn, JohnDoe",
            "John, Doe, doejohn, doejohn",
            "john, john, john, john",
            "John, Doe, DoeJohn, doejohn",
            "John, Doe, doejohn, DoeJohn",
    })
    void testFindByName(String firstName, String lastName, String username, String searchString) {
        Profile profile = (new ProfileBuilder())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUsername(username)
                .build();
        profileRepository.save(profile);

        Profile foundProfile = profileRepository.findByFullNameOrUsername(searchString).orElse(null);

        assertThat(foundProfile).isEqualTo(profile);
    }
}