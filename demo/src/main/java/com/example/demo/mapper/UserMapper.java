package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findUserList();

    @Insert("insert into user(email,userName,password,nickName,regTime) values(#{email},#{userName},#{password},#{nickName},#{regTime})")
    void save(User user);
}
