package com.kzhou.luban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PowerApplicationRunning {
    public static void main(String[] args) {
        SpringApplication.run(PowerApplicationRunning.class);
    }
}
