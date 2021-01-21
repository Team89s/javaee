package com.igeek.ch04.controller;

import com.igeek.ch04.entity.Items;
import com.igeek.ch04.service.ItemsService;
import com.igeek.ch04.vo.PageVO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
                case "validate":
                    String name = request.getParameter("name");
                    boolean flag = service.validate(name);
                    String message = "";
                    if(flag){
                        message = "当前商品名称可以使用";
                    }else{
                        message = "当前商品名称已被占用";
                    }

                    //以json数据格式，将flag、message的值传递至页面
                    JSONObject obj = new JSONObject();
                    //将两个数据绑定到json数据上
                    obj.put("flag",Boolean.toString(flag));
                    obj.put("message",message);

                    //通过响应获得输出流
                    PrintWriter out = response.getWriter();
                    //将json数据以字符串的形式写到页面中
                    out.println(obj.toString());
                    out.flush();
                    out.close();

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
