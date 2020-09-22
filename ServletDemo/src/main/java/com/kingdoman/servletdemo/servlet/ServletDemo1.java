package com.kingdoman.servletdemo.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet使用步骤
 * 1.创建JavaEE项目
 * 2.定义一个类实现Servlet接口，覆盖重写所有方法
 * 3.在web.xml中配置servlet
 * <p>
 * Servlet是单例的，多线程不安全；解决方案:不在servlet中定义成员变量，或者定义成员变量不修改它
 */
public class ServletDemo1 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("my servlet test");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
