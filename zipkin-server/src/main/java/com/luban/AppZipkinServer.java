package com.luban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class AppZipkinServer {
    public static void main(String[] args) {
        SpringApplication.run(AppZipkinServer.class);
    }
}
