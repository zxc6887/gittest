package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> getUserList() {
        List<User> userList = userMapper.findUserList();
        return userList;
    }

    @RequestMapping("/save")
    public User save(User user) {
        if(null == user){
            user = new User();
        }
        user.setUserName("苏雨");
        user.setPassword("bugaosuni");
        user.setNickName("suyu");
        user.setEmail("645328305@qq.com");
        user.setRegTime("2019-05-05 16:12:00");
        logger.info("user:{}",user);
        userMapper.save(user);
        return user;
    }
}
