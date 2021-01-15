package com.igeek.ch02.service;

import com.igeek.ch02.dao.UserDao;
import com.igeek.ch02.entity.User;
import com.igeek.ch02.utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/15 11:06
 */
public class UserService {

    private UserDao dao = new UserDao();

    public User login(String username , String password){
        User user = null;
        try {
            user = dao.selectOne(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeConn();
        }
        return user;
    }


}
