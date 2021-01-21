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

    //通过商品名称查询信息  精确查询
    public Items selectOne(String name) throws SQLException {
        String sql = "select * from items where name = ?";
        Items items = this.getBean(sql, Items.class, name);
        return items;
    }

    //添加商品信息
    public int insert(Items items) throws SQLException {
        String sql = "insert into items values(null,?,?,?,?,?)";
        int i = this.update(sql, items.getName(), items.getPrice(), items.getDetail(),
                items.getPic(), items.getCreatetime());
        return i;
    }

    //通过id查询单个商品信息
    public Items selectOne(Integer id) throws SQLException {
        String sql = "select * from items where id = ?";
        Items items = this.getBean(sql, Items.class, id);
        return items;
    }

    //更新商品信息
    public int update(Items items) throws SQLException {
        String sql = "update items set name = ? , price = ? , detail = ? , createtime = ? , pic = ? where id = ?";
        int i = this.update(sql, items.getName(), items.getPrice(), items.getDetail(),
                items.getCreatetime(), items.getPic(), items.getId());
        return i;
    }

    public int delete(Integer id) throws SQLException {
        String sql = "delete from items where id = ?";
        int i = this.update(sql, id);
        return i;
    }
}
