package com.wheeler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

//    @Bean
//    public Function<User, Greeting> hello() {
//        return user -> new Greeting("Welcome, " + user.getName());
//    }
}
