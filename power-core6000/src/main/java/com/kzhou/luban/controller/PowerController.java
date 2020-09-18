package com.kzhou.luban.controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PowerController {

    @RequestMapping("/getPower.do")
    public Object getPoder(String name) throws Exception{
        Map<String,Object> map = new HashMap();
        map.put("key","power");
        if(StringUtils.isEmpty(name)){
            throw new Exception();
        }
        return map;
    }

    @RequestMapping("/getPower-ribbon.do")
    public Object getPower(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","getPower-ribbon");

        return map;
    }

}
