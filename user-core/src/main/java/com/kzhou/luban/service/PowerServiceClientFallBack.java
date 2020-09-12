package com.kzhou.luban.service;

import com.kzhou.luban.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class PowerServiceClientFallBack implements PowerServiceClient{

    @Override
    public R getPower() {
        return R.error("系统正在维护中，请稍后重试");
    }
}
