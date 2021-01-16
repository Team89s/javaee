package com.igeek.ch02.servlet;

import com.igeek.ch02.entity.User;
import com.igeek.ch02.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "UserServlet" , urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求中的编码集
        request.setCharacterEncoding("UTF-8");

        //会话属性  Servlet中的会话HttpSession由自己创建
        HttpSession session = request.getSession();

        String code = request.getParameter("code");

        if(code!=null){
            switch (code){
                case "login":  //登录

                    //获得请求参数
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String timeLength = request.getParameter("timeLength");

                    UserService service = new UserService();

                    if(username!=null && password!=null){
                        User user = service.login(username, password);

                        if(user!=null) {
                            String state = user.getState();
                            switch (state){
                                case "0":
                                    request.setAttribute("msg","当前账户未审核，请耐心等待");
                                    request.getRequestDispatcher("userLogin.jsp").forward(request,response);
                                    break;
                                case "1":
                                    //登录成功

                                    //简化登录：通过Cookie存储姓名和密码
                                    if(timeLength!=null && !timeLength.equals("0")){
                                        int day = Integer.parseInt(timeLength);

                                        //1.创建Cookie
                                        //编码
                                        Cookie usernameCookie = new Cookie("usernameCookie", URLEncoder.encode(username,"UTF-8"));
                                        Cookie passwordCookie = new Cookie("passwordCookie",password);

                                        //2.设置有效时长，存储在浏览器所在的PC机上
                                        usernameCookie.setMaxAge(day*24*60*60);
                                        passwordCookie.setMaxAge(day*24*60*60);

                                        //3.响应至客户端
                                        response.addCookie(usernameCookie);
                                        response.addCookie(passwordCookie);
                                    }

                                    //会话属性中存储了当前登录的user信息
                                    session.setAttribute("user",user);

                                    //设置最大非活动时间  默认tomcat是30分钟
                                    //session.setMaxInactiveInterval(2*60*60);

                                    request.getRequestDispatcher("success.jsp").forward(request,response);
                                    break;
                                case "2":
                                    request.setAttribute("msg","当前账户审核失败，请重新提交信息");
                                    request.getRequestDispatcher("userLogin.jsp").forward(request,response);
                                    break;
                            }
                        }else{
                            request.setAttribute("msg","姓名和密码不匹配，登录失败");
                            request.getRequestDispatcher("userLogin.jsp").forward(request,response);
                        }
                    }else{
                        //请求属性
                        request.setAttribute("msg","姓名或密码有误，登录失败");
                        request.getRequestDispatcher("userLogin.jsp").forward(request,response);
                    }

                    break;
                case "logout":  //登出
                    //会话销毁
                    session.invalidate();
                    request.setAttribute("msg","当前已成功退出");
                    request.getRequestDispatcher("userLogin.jsp").forward(request,response);
                    break;
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
