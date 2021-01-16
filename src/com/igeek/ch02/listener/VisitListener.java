package com.igeek.ch02.listener;

import com.igeek.ch02.service.VisitService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

//监听器ServletContextListener：监听容器启动和关闭 --》 事件ServletContextEvent：上下文对象的创建和销毁
@WebListener()
public class VisitListener implements ServletContextListener {

    private VisitService service = new VisitService();

    // Public constructor is required by servlet spec
    public VisitListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    //上下文对象初始化
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        //查看统计人次的数据
        Object count = service.viewCount();
        System.out.println("初始化时：count = "+count);
        //获取上下文对象
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("count",count);
    }

    //上下文对象销毁
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        //获取当前上下文对象中最新的人次
        ServletContext sc = sce.getServletContext();
        Object count = sc.getAttribute("count");
        System.out.println("销毁时：count = "+count);
        //存进数据库中
        service.modifyCount(count);
    }
}
