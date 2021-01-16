package com.igeek.ch02.dao;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description 登录访问人次的表操作
 * @Author chenmin
 * @Date 2021/1/16 15:13
 */
public class VisitDao extends BaseDao{

    //查询
    public Object selectCounts() throws SQLException {
        Object o = this.getSingleValue("select count from visit");
        return o;
    }

    //更新
    public void updateCount(Object count) throws SQLException {
        int i = this.update("update visit set count = ?", count);
        System.out.println(i>0?"更新成功":"更新失败");
    }

}
