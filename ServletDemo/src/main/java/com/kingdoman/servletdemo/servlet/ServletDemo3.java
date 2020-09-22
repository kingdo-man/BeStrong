package com.kingdoman.servletdemo.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * servlet使用步骤
 * 不再重写所有方法,GenericServlet对其他方法进行了空实现，可手动添加
 */

//@WebServlet(urlPatterns = "/servletdemo2")
@WebServlet("/servletdemo3")
public class ServletDemo3 extends GenericServlet {

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("my servlet test3 with servlet 4 don't override other method !!!");
    }

}
