package com.luban.service;


import com.luban.entity.User;

import java.util.List;

public interface UserService {
    Integer insertUser(User user);

    List<User> selectUser();
}
