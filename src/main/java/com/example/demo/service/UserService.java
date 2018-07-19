package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserDao;
import com.example.demo.entity.User;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserInfo(String username){
        User user=userDao.findUserInfo(username);
        return user;
    }
    
    public void registUser(User user){
        userDao.regist(user);
    }

}
