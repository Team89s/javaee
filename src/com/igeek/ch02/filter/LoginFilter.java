package com.igeek.ch02.filter;

import com.igeek.ch02.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

/**
 * 登录访问控制过滤器
 */
@WebFilter(filterName = "f2" , urlPatterns = {"/testJSP/*","/fail.jsp"},
    initParams = {@WebInitParam(name="begin",value = "18") , @WebInitParam(name = "end" , value = "20")})
public class LoginFilter implements Filter {

    private int begin;
    private int end;

    public LoginFilter(){
        System.out.println("LoginFilter()  实例化");
    }

    public void destroy() {
        System.out.println("LoginFilter destroy()  销毁");
    }

    /**
     * doFilter 过滤方法
     * @param req   请求对象
     * @param resp  响应对象
     * @param chain 过滤链
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter doFilter()");

        //获得会话对象HttpSession
        HttpServletRequest request = ((HttpServletRequest)req);
        HttpSession session = request.getSession();

        //从会话属性中获得登录的信息
        User user = (User)session.getAttribute("user");
        LocalTime time = LocalTime.now();
        System.out.println("当前时间："+time.getHour());
        if(time.getHour() < begin || time.getHour() > end){
            if(user==null){  //不放行
                //跳转至登录界面
                request.setAttribute("msg","当前资源必须登录后访问");
                request.getRequestDispatcher(request.getContextPath()+"/userLogin.jsp").forward(request,resp);
                return;
            }
        }

        //过滤链  放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter init()  初始化");
        begin = Integer.parseInt(config.getInitParameter("begin"));
        end = Integer.parseInt(config.getInitParameter("end"));
        System.out.println(begin + " ~ "+end);
    }

}
