package com.kzhou.luban.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@ComponentScan("com.kzhou.luban")
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Bean
    /**
     * 将一个应用以tomcat内嵌启动的方式有以下三种
     * 1.自己搭建一个tomcat并且将DispatcherServlet给容器
     * 2.Maven依赖一个SpringBoot的web包，这样容器在启动的时候会启动内嵌的这个Web下Tomcat
     * 3.配置一个Bean，TomcatServletWebServerFactory，这样也会启动Tomcat并且完成对应的配置
     */
    public TomcatServletWebServerFactory tomcat(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(8080);
        return tomcat;
    }
}
