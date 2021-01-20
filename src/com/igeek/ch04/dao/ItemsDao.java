package com.igeek.ch04.dao;

import com.igeek.ch04.entity.Items;

import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/20 16:12
 */
public class ItemsDao extends BaseDao<Items> {

    //件模糊查询商品表的记录总数
    public Long selectCounts(String query) throws SQLException {
        String sql = "select count(*) from items where name like concat('%',?,'%')";
        Long value = (Long)this.getSingleValue(sql, query);
        return value;
    }

    //分页+条件模糊查询商品表的所有信息
    public List<Items> selectAll(String query , int begin) throws SQLException {
        String sql = "select * from items where name like concat('%',?,'%') limit ?,3";
        List<Items> itemsList = this.getBeanList(sql, Items.class, query, begin);
        return itemsList;
    }

}
