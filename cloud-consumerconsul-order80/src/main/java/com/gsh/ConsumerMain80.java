package com.gsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain80 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConsumerMain80.class, args);
    }
}
