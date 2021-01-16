package com.igeek.ch02.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 需求：编码集过滤器
 * @WebFilter    过滤器的注解
 * 1.filterName  过滤器名称，名称会决定过滤器的执行顺序
 * 2.urlPatterns 过滤路径，/*代表过滤所有路径
 * 3.initParams  过滤器的初始化参数  @WebInitParam 其中name初始化参数的名字，value就是其值
 */
@WebFilter(filterName = "EncodeFilter" , urlPatterns = "/*" ,
    initParams = {@WebInitParam(name="encode" , value = "utf-8")})
public class EncodeFilter implements Filter {

    private String encode;

    //销毁方法
    public void destroy() {
        System.out.println("EncodeFilter destroy()");
    }

    //执行过滤的逻辑
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("EncodeFilter doFilter...");
        //处理了请求和响应
        req.setCharacterEncoding(encode);
        resp.setContentType("text/html;charset="+encode);

        //过滤链：将处理好的请求和响应继续链接下去，有可能下一个是过滤器，有可能下一个是目标资源
        chain.doFilter(req, resp);
    }

    //初始化方法
    public void init(FilterConfig config) throws ServletException {
        System.out.println("EncodeFilter init()");
        encode = config.getInitParameter("encode");
        System.out.println("encode = "+encode);
    }

}
