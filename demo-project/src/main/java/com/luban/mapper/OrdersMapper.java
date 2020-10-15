package com.luban.mapper;


import com.luban.entity.User;
import org.apache.ibatis.annotations.Insert;

public interface OrdersMapper {
    @Insert({"insert into orders(id,name) values(#{sid},#{sname})"})
    Integer insertOrders(User user);
}
