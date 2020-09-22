package com.kingdoman.servletdemo.filterandlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener
 * 实现：
 * 1.定义一个类实现ServletContextListener接口
 * 2.复写方法
 * 3.配置
 */
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 加载配置文件
        ServletContext servletContext = sce.getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        String realPath = servletContext.getRealPath(contextConfigLocation);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
