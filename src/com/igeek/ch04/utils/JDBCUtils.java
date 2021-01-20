package com.igeek.ch04.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/15 11:06
 */
public class JDBCUtils {

    private static ComboPooledDataSource pool = new ComboPooledDataSource("mysql");

    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    //获得连接对象
    public static Connection getConn(){
        Connection conn = tl.get();
        try {
            if(conn==null || conn.isClosed()){
                conn = pool.getConnection();
                tl.set(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    //释放连接
    public static void closeConn(){
        Connection conn = tl.get();
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
