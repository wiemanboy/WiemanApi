package com.wiemanboy.wiemanapi;

import com.wiemanboy.wiemanapi.config.TestSecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest(classes = {TestSecurityConfig.class, WiemanApiApplication.class})
class WiemanApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
