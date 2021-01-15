package com.igeek.ch02.dao;

import com.igeek.ch02.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description 基础的CRUD
 * @Author chenmin
 * @Date 2021/1/15 11:05
 */
public class BaseDao<T> {

    private QueryRunner runner = new QueryRunner();

    //增删改

    //查询单个对象
    public T getBean(String sql , Class<T> clazz , Object...params){
        try {
            T t = runner.query(JDBCUtils.getConn() , sql , new BeanHandler<>(clazz) , params);
            return t;
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally{
            JDBCUtils.closeConn();
        }
    }

    //查询多个对象

    //查询单个值
}
