package com.kzhou.luban.controller;

import com.kzhou.luban.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getUser.do")
    public R getUser(){
        Map<String,Object> map = new HashMap();
        map.put("key","user");
        return R.success("返回成功",map);
    }

    @RequestMapping("/getPower.do")
    public R getPower(){
        return R.success("返回成功",restTemplate.getForObject("http://localhost:9000/getPower.do",Object.class));
    }
}
