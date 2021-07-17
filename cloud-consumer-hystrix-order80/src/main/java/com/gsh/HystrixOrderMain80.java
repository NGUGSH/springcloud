package com.gsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class HystrixOrderMain80 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(HystrixOrderMain80.class, args);
    }
}
