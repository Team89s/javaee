package com.igeek.ch03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ScopeServlet" , urlPatterns = "/scope")
public class ScopeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求域
        request.setAttribute("name","唐僧");

        //会话域
        HttpSession session = request.getSession();
        session.setAttribute("name","沙和尚");

        //上下文域
        ServletContext sc = this.getServletContext();
        sc.setAttribute("name","悟空");

        request.getRequestDispatcher("testEL/scope.jsp").forward(request,response);
    }
}
