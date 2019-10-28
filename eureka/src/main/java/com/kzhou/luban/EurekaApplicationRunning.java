package com.kzhou.luban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationRunning {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationRunning.class);
    }
}
