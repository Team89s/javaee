package com.igeek.ch01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发和响应重定向之间的区别：
 * 1.请求转发：不会产生新的请求 ； 响应重定向：会产生新的请求
 * 2.请求转发：可以携带数据 ； 响应重定向：不会携带数据
 * 3.请求转发：地址栏不会发生变化，显示请求地址 ； 响应重定向：地址栏会发生变化，显示目标地址，避免重复提交表单
 * 4.请求转发的地址，只能是项目中的地址URL ； 响应重定向的地址，可以是任意地址URL
 */
@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获得请求参数  request.getParameter("1.input中的name值  2.地址栏中?key1=value1&key2=value2的key1、key2")
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username!=null && !"".equals(username)){
            //跳转至成功界面

            //响应重定向：会产生新的请求，不会携带数据
            //response.sendRedirect("success");

            //请求转发：不会产生新的请求，沿用之前的请求，所以可以携带数据
            request.getRequestDispatcher("success").forward(request,response);

        }else{
            //跳转至失败界面

            //响应重定向
            response.sendRedirect("fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
