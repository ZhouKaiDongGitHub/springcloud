package com.luban.service.impl;

import com.luban.entity.User;
import com.luban.mapper.OrdersMapper;
import com.luban.service.OrdersService;

import com.luban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    UserService userService;


    @Override
    public Integer insertOrders(User user) {
        Integer integer = userService.insertUser(user);
        Integer integer1 = ordersMapper.insertOrders(user);
//        int i=1/0;
        return integer1+10;
    }
}
