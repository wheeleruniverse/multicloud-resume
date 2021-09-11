package com.wheeler.azure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.wheeler")
@Configuration
public class AppConfig {

    @Value("${cosmos.auth}")
    private String cosmosAuth;

    @Bean
    public String cosmosAuth(){
        return cosmosAuth;
    }

    @Value("${cosmos.host}")
    private String cosmosHost;

    @Bean
    public String cosmosHost(){
        return cosmosHost;
    }

    @Value("${cosmos.name}")
    private String cosmosName;

    @Bean
    public String cosmosName(){
        return cosmosName;
    }
}
