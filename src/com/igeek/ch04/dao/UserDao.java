package com.igeek.ch04.dao;

import com.igeek.ch04.entity.User;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/20 15:38
 */
public class UserDao extends BaseDao<User> {

    public User selectOne(String name , String pwd) throws SQLException {
        User user = this.getBean("select * from user where name = ? and pwd = ?",
                User.class, name, pwd);
        return user;
    }

}
