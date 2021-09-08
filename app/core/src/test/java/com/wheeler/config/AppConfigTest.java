package com.wheeler.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = AppConfig.class)
@ExtendWith(SpringExtension.class)
@SpringBootConfiguration
@SpringBootTest
@TestPropertySource(properties = {
        "cosmos.auth=auth1",
        "cosmos.host=host1",
        "cosmos.name=name1"
})
public class AppConfigTest {

    @Autowired
    private AppConfig appConfig;

    @Test
    public void cosmosAuth(){
        String actual = appConfig.cosmosAuth();
        Assertions.assertEquals("auth1", actual);
    }

    @Test
    public void cosmosHost(){
        String actual = appConfig.cosmosHost();
        Assertions.assertEquals("host1", actual);
    }

    @Test
    public void cosmosName(){
        String actual = appConfig.cosmosName();
        Assertions.assertEquals("name1", actual);
    }
}
