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
            //System.out.println("vo = "+vo);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConn();
        }
        return vo;
    }

    //校验商品名称是否存在
    public boolean validate(String name){
        try {
            Items items = dao.selectOne(name);
            if(items!=null){
                return false;  //当前商品名称已使用，则不能使用
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConn();
        }
        return true;  //当前商品名称未使用，则可以使用
    }

    //商品上架
    public boolean add(Items items){
        boolean flag = this.validate(items.getName());
        if(flag){
            try {
                int i = dao.insert(items);
                if(i>0){
                    //插入成功
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //插入失败
        return false;
    }

    //通过id查询商品
    public Items viewOne(Integer id){
        try {
            return dao.selectOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConn();
        }
        return null;
    }

    //更新商品信息
    public boolean update(Items items){
        //数据库中原商品的名称
        String oldName = this.viewOne(items.getId()).getName();
        //从表单中提交来的商品名称
        String newName = items.getName();
        boolean flag = true;
        if(!oldName.equals(newName)){
            //更新商品名称，需要做校验
            flag = this.validate(items.getName());
        }
        if(flag){
            //更新
            try {
                int i = dao.update(items);
                if(i>0){
                    //更新成功
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeConn();
            }
        }
        //更新失败
        return false;
    }

    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            try {
                dao.delete(id);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeConn();
            }
        }
    }
}
