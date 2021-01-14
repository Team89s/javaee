package com.igeek.ch01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet的生命周期
 * 1.CircleServlet 实例化   在访问对应的Servlet时，有且只会实例化一次
 * 2.CircleServlet 初始化   有且只会初始化一次，加载初始化的参数、加载属性文件等
 * 3.doGet   每次根据访问方式的不同，执行doXxx方法
 * 4.doGet
 * 5.CircleServlet 销毁    关闭容器，执行销毁方法，容器关闭之前释放资源、存储日志等
 */

/**
 * 1.initParams  Servlet的初始化参数的配置 ， 搭配 @WebInitParam 使用，允许配置多个值
 * 2.loadOnStartup  配置后，在tomcat容器启动时，直接实例化、初始化Servlet；
 * 若出现多个配置了loadOnStartup的值的情况，则值越小越先加载
 */
@WebServlet(name = "CircleServlet" , urlPatterns = "/circle"
        ,initParams = {@WebInitParam(name="version",value="1.0")}
        ,loadOnStartup = 1)
public class CircleServlet extends HttpServlet {

    public CircleServlet(){
        System.out.println("CircleServlet 实例化");
    }

    //销毁
    @Override
    public void destroy() {
        System.out.println("CircleServlet 销毁");
    }

    //初始化
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("CircleServlet 初始化");
        String version = config.getInitParameter("version");
        System.out.println("version = "+version);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
    }
}
