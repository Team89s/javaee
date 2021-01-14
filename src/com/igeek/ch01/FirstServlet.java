package com.igeek.ch01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "FirstServlet" , urlPatterns = "/first" , loadOnStartup = 2)
public class FirstServlet extends HttpServlet {

    public FirstServlet(){
        System.out.println("FirstServlet 实例化");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");

        //设置request的编码集
        request.setCharacterEncoding("UTF-8");
        //设置response的编码集
        response.setContentType("text/html;charset=UTF-8");

        //获取请求参数
        // 获取单个值  request.getParameter("表单中input的name的值");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 获取多个值
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username = "+username +", password = "+password+",hobbies="+ Arrays.toString(hobbies));

        if(username!=null && !"".equals(username)){
            //响应一个页面数据
            response.getWriter().write("欢迎："+username);
        }

        //获取请求参数  Map的key是input中name的值 ； value表单中填写的数据
        /*Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        for (String key : keys) {
            String[] values = parameterMap.get(key);
            System.out.println("key = "+key +", value = "+Arrays.toString(values));
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        this.doPost(request,response);
    }
}
