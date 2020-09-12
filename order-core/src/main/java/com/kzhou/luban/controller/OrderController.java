package com.kzhou.luban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    @RequestMapping("/getOrder.do")
    public Object getOrder(String name) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("key","order");
        /*if(StringUtils.isEmpty(name)){
            throw new Exception();
        }*/
        Thread.sleep(2000);
        return map;
    }
}
