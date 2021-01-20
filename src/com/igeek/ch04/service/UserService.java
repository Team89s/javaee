package com.igeek.ch04.service;

import com.igeek.ch02.utils.JDBCUtils;
import com.igeek.ch04.dao.UserDao;
import com.igeek.ch04.entity.User;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/20 15:39
 */
public class UserService {

    private UserDao dao = new UserDao();

    //登陆
    public User login(String name , String pwd){
        try {
            User user = dao.selectOne(name, pwd);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConn();
        }
        return null;
    }

}
