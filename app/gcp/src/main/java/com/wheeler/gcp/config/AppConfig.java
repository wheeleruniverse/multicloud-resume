package com.wheeler.gcp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.wheeler")
@Configuration
public class AppConfig {

    @Value("${com.wheeler.gcp.credentials}")
    private String credentials;

    @Bean
    public String credentials(){
        return credentials;
    }

    @Value("${com.wheeler.gcp.project}")
    private String project;

    @Bean
    public String project(){
        return project;
    }
}
