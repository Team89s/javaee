package com.igeek.ch02.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

//监听当前会话中的属性情况
@WebListener()
public class MyListener implements HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public MyListener() {
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------
    // 属性添加
    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        String name = sbe.getName();
        Object value = sbe.getValue();
        System.out.println("会话中新增属性："+name +" = "+value);
    }

    // 属性移除
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        String name = sbe.getName();
        Object value = sbe.getValue();
        System.out.println("会话中移除属性："+name +" = "+value);
    }

    // 属性替换
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        String name = sbe.getName();
        Object value = sbe.getValue();
        System.out.println("会话中替换属性："+name +" = "+value);
    }
}
