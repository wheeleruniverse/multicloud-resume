package com.wheeler.aws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.wheeler")
@Configuration
public class AppConfig {

    @Value("${com.wheeler.aws.region}")
    private String region;

    @Bean
    public String region() {
        return region;
    }
}
