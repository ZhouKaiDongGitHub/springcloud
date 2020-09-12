package com.kzhou.luban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderApplicationRunning {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationRunning.class);
    }
}
