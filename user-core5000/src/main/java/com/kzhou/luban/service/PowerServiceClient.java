package com.kzhou.luban.service;

import com.kzhou.luban.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="SERVER-POWER",fallback = PowerServiceClientFallBack.class)
public interface PowerServiceClient {

    @RequestMapping("/getPower.do")
    public R getPower();
}
