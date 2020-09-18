package com.kzhou.luban.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PowerController {


    @RequestMapping("/getPower.do")
    public Object getPoser(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","power1");

        return map;
    }

    @RequestMapping("/getPower-ribbon.do")
    public Object getPower(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","getPower-ribbon1");

        return map;
    }

}
