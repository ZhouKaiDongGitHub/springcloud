package com.kzhou.luban.controller;

import com.kzhou.luban.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//RestController规定了返回值必须是Rest风格的Json，因此所有的返回值无需加上ResponseBody
@RestController
public class UserController {


    @Autowired
    /**
     * RPC调用是分布式的核心概念，如何保持各个服务间的通讯？
     * 通讯必定是基于TCP的，只是在其上面有http，Socket，WebSocket等等协议
     * 技术有Java原生的JMI,Socket,WebService,Http等等。这边简单借助一下Spring封装http的框架restTemplate
     */
    RestTemplate restTemplate;

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
}
