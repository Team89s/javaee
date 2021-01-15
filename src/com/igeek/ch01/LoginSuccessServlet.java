package com.igeek.ch01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginSuccessServlet" , urlPatterns = "/success")
public class LoginSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //获得请求属性
        String msg = request.getAttribute("msg").toString();

        //响应数据
        response.getWriter().write(msg+"<br/>");
        response.getWriter().write(" login success , 欢迎："+request.getParameter("username"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
