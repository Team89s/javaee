package com.igeek.ch04.controller;

import com.igeek.ch04.entity.Items;
import com.igeek.ch04.service.ItemsService;
import com.igeek.ch04.vo.PageVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ItemsServlet" , urlPatterns = "/items")
public class ItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ItemsService service = new ItemsService();
        String code = request.getParameter("code");

        if(code!=null && !"".equals(code)){
            switch (code){
                case "viewAll":
                    //获取当前页码
                    String page = request.getParameter("pageNow");
                    int pageNow = 0;
                    if(page == null){
                        pageNow = 1;  //默认查询第一页
                    }else{
                        pageNow = Integer.parseInt(page);
                    }

                    //获取当前查询条件
                    String query = request.getParameter("query");
                    if(query ==null){
                        query = "";  //默认没有条件，查询所有
                    }

                    PageVO<Items> pageVO = service.viewAll(query, pageNow);
                    request.setAttribute("vo",pageVO);
                    request.getRequestDispatcher("items/itemsList.jsp").forward(request,response);
                    break;
                case "add":
                    break;
                case "viewOne":
                    break;
                case "update":
                    break;
                case "delete":
                    break;
                default:
                    System.out.println("没有匹配操作项");
                    break;
            }
        }

    }
}
