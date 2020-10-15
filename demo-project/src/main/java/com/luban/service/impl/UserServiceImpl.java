package com.luban.service.impl;


import com.luban.entity.User;
import com.luban.mapper.UserMapper;
import com.luban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }
}
