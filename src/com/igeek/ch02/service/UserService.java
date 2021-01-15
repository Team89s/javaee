package com.igeek.ch02.service;

import com.igeek.ch02.dao.UserDao;
import com.igeek.ch02.entity.User;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/15 11:06
 */
public class UserService {

    private UserDao dao = new UserDao();

    public User login(String username , String password){
        User user = dao.selectOne(username, password);
        return user;
    }


}
