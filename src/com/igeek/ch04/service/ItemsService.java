package com.igeek.ch04.service;

import com.igeek.ch02.utils.JDBCUtils;
import com.igeek.ch04.dao.ItemsDao;
import com.igeek.ch04.entity.Items;
import com.igeek.ch04.vo.PageVO;

import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/20 16:17
 */
public class ItemsService {

    private ItemsDao dao = new ItemsDao();

    //分页 + 条件模糊查询
    public PageVO<Items> viewAll(String query , int pageNow){
        PageVO<Items> vo = null;
        try {
            //获得总记录数
            Long counts = dao.selectCounts(query);
            //计算总页数
            int myPages = (int)(counts%3==0 ? counts/3.0 : Math.ceil(counts/3.0));
            //计算每页的起始值
            int begin = (pageNow - 1)*3;
            //获得查询数据
            List<Items> list = dao.selectAll(query, begin);
            //封装
            vo = new PageVO<>(query,pageNow,myPages,list);
            System.out.println("vo = "+vo);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConn();
        }
        return vo;
    }

}
