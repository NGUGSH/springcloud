package com.gsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignMain80 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OpenFeignMain80.class, args);
    }
}
