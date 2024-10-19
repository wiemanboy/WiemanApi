package com.wiemanboy.wiemanapi;

import com.wiemanboy.wiemanapi.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SecurityConfig.class, WiemanApiApplication.class})
class WiemanApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
