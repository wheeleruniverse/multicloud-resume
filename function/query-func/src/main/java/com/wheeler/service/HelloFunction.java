package com.wheeler.service;

import com.wheeler.dao.model.Greeting;
import com.wheeler.dao.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Configuration
public class HelloFunction {

    @Bean
    public Function<User, Greeting> hello() {
        return user -> new Greeting("Welcome, " + user.getName());
    }
}
