package com.kingdoman.servletdemo.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * servlet使用步骤
 * 1.创建JavaEE项目
 * 2.定义一个类实现Servlet接口，覆盖重写所有方法
 * 3.在web.xml中配置servlet
 * <p>
 * Servlet是单例的，多线程不安全；解决方案:不在servlet中定义成员变量，或者定义成员变量不修改它
 * <p>
 * <p>
 * 配置Servlet很复杂 3.0之后支持通过注解配置@WebServlet，可以不要web.xml
 */

//@WebServlet(urlPatterns = "/servletdemo2")
@WebServlet("/servletdemo2")
public class ServletDemo2 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("my servlet test2 with servlet 4");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
