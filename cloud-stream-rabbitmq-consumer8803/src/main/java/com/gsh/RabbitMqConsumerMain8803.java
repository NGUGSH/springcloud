package com.gsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitMqConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerMain8803.class,args);
    }
}
