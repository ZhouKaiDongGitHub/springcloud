package com.kzhou.luban.controller;

import com.kzhou.luban.service.OrderServiceClient;
import com.kzhou.luban.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//RestController规定了返回值必须是Rest风格的Json，因此所有的返回值无需加上ResponseBody
@RestController
public class UserController {

    private static final String POWER_URL= "http://server-power";
    private static final String ORDER_URL= "http://server-order";
    /**
     * RPC调用是分布式的核心概念，如何保持各个服务间的通讯？
     * 通讯必定是基于TCP的，只是在其上面有http，Socket，WebSocket等等协议
     * 技术有Java原生的JMI,Socket,WebService,Http等等。这边简单借助一下Spring封装http的框架restTemplate
     */
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderServiceClient orderServiceClient;

    @RequestMapping("/getUser.do")
    public R getUser(){
        Map<String,Object> map = new HashMap();
        map.put("key","user");
        return R.success("返回成功",map);
    }

    @RequestMapping("/getPower.do")
    public R getPower(){
        //这边url请求到了nginx进行了负载均衡。
        //端口号是9000，会代理到6000和6001服务器
        return R.success("返回成功",restTemplate.getForObject("http://localhost:9000/getPower.do",Object.class));
    }

    @RequestMapping("/getPower-ribbon.do")
    public R getPowerRibbon(){
        return R.success("返回成功",restTemplate.getForObject(POWER_URL+"/getPower-ribbon.do",Object.class));
    }

    @RequestMapping("/getOrder.do")
    public R getOrder(){
        return R.success("返回成功",restTemplate.getForObject(ORDER_URL+"/getOrder.do",Object.class));
    }

    @RequestMapping("/getFeignOrder.do")
    @HystrixCommand(fallbackMethod = "getFeignOrderFallBack",threadPoolKey = "power",threadPoolProperties = {@HystrixProperty(name="coreSize",value = "5")})
    public R getFeignOrder(){
        return R.success("操作成功", orderServiceClient.getOrder());
    }

    private R getFeignOrderFallBack(){
        return R.error("系统正在维护中，请稍后重试");
    }
}
