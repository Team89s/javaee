package com.igeek.ch04.vo;

import com.igeek.ch04.entity.Items;

import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/20 16:22
 */
public class PageVO<T> {
    //查询条件
    private String query;
    //当前页数
    private int pageNow;
    //总页数
    private int myPages;
    //数据项
    private List<T> list;


    public PageVO() {
    }

    public PageVO(String query, int pageNow, int myPages, List<T> list) {
        this.query = query;
        this.pageNow = pageNow;
        this.myPages = myPages;
        this.list = list;
    }

    /**
     * 获取
     * @return query
     */
    public String getQuery() {
        return query;
    }

    /**
     * 设置
     * @param query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 获取
     * @return pageNow
     */
    public int getPageNow() {
        return pageNow;
    }

    /**
     * 设置
     * @param pageNow
     */
    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    /**
     * 获取
     * @return myPages
     */
    public int getMyPages() {
        return myPages;
    }

    /**
     * 设置
     * @param myPages
     */
    public void setMyPages(int myPages) {
        this.myPages = myPages;
    }

    /**
     * 获取
     * @return list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public String toString() {
        return "PageVO{query = " + query + ", pageNow = " + pageNow + ", myPages = " + myPages + ", list = " + list + "}";
    }
}
