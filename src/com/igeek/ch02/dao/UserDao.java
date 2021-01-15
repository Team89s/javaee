package com.igeek.ch02.dao;

import com.igeek.ch02.entity.User;
import com.igeek.ch02.utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/15 11:05
 */
public class UserDao extends BaseDao<User> {

    //通过姓名和密码查询用户信息
    public User selectOne(String username , String password) throws SQLException {
        User user = this.getBean("select * from user where name = ? and pwd = ?", User.class, username, password);
        return user;
    }

}
