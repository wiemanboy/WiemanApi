package com.wiemanboy.wiemanapi.presentation;

import com.wiemanboy.wiemanapi.WiemanApiApplication;
import com.wiemanboy.wiemanapi.builders.ProfileBuilder;
import com.wiemanboy.wiemanapi.config.TestSecurityConfig;
import com.wiemanboy.wiemanapi.data.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {TestSecurityConfig.class, WiemanApiApplication.class})
@AutoConfigureMockMvc
public class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        Mockito.reset(profileRepository);
    }

    @Test
    void testGetProfile() throws Exception {
        Mockito.when(profileRepository.findById("1")).thenReturn(Optional.of((new ProfileBuilder()).build()));

        mockMvc.perform(get("/api/profiles/{id}", "1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetProfileNotFound() throws Exception {
        Mockito.when(profileRepository.findById("1")).thenReturn(java.util.Optional.empty());

        mockMvc.perform(get("/api/profiles/{id}", "1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetProfileByName() throws Exception {
        Mockito.when(profileRepository.findByFullNameOrUsername("johndoe")).thenReturn(Optional.of((new ProfileBuilder()).build()));

        mockMvc.perform(get("/api/profiles/{name}/{locale}", "johndoe", "en"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetProfileByNameNotFound() throws Exception {
        Mockito.when(profileRepository.findById("1")).thenReturn(java.util.Optional.empty());

        mockMvc.perform(get("/api/profiles/{name}/{locale}", "johndoe", "en"))
                .andExpect(status().isNotFound());
    }
}