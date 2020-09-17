package com.kzhou.luban.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

public class PowerRuleConfig {

    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }
}
