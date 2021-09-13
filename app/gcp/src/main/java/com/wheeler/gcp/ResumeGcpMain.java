package com.wheeler.gcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResumeGcpMain {

    public static void main(String[] args){
        SpringApplication.run(ResumeGcpMain.class, args);
    }
}

// export GOOGLE_APPLICATION_CREDENTIALS="/home/user/Downloads/service-account-file.json"
