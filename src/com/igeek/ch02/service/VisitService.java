package com.igeek.ch02.service;

import com.igeek.ch02.dao.VisitDao;
import com.igeek.ch02.utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/16 15:20
 */
public class VisitService {

    private VisitDao dao = new VisitDao();

    public Object viewCount(){
        try {
            return dao.selectCounts();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConn();
        }
        return 0L;
    }

    public void modifyCount(Object count){
        try {
            dao.updateCount(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConn();
        }
    }

}
