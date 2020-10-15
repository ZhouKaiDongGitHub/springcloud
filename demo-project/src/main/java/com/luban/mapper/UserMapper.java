package com.luban.mapper;


import com.luban.annotation.MyDataSource;
import com.luban.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


    @Insert({"insert into user(id,name) values(#{sid},#{sname})"})
    Integer insertUser(User user);


    @MyDataSource("slave")
    @Select("select id as sid,name as sname from user")
    List<User> selectUser();
}
