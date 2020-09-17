package com.kzhou.luban.service;

import com.kzhou.luban.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="SERVER-ORDER")
public interface OrderServiceClient {

    @RequestMapping("/getOrder.do")
    public R getOrder();
}
