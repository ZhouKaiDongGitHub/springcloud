package com.kzhou.luban.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyIRule  extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //to do nothing
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    private Server choose(ILoadBalancer lb,Object key){
        List<Server> serverList = lb.getAllServers();
        return serverList.get(0);
    }
}
