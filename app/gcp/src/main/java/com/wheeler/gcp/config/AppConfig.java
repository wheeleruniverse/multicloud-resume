package com.wheeler.gcp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.wheeler")
@Configuration
public class AppConfig {

    @Value("${gcp.credentials}")
    private String gcpCredentials;

    @Bean
    public String gcpCredentials(){
        return gcpCredentials;
    }

    @Value("${gcp.project}")
    private String gcpProject;

    @Bean
    public String gcpProject(){
        return gcpProject;
    }
}
