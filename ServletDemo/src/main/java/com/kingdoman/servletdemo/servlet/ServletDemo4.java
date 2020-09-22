package com.kingdoman.servletdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet使用步骤
 * 不再重写所有方法,GenericServlet对其他方法进行了空实现，可手动添加
 */

//@WebServlet(urlPatterns = "/servletdemo2")
@WebServlet("/servletdemo4")
public class ServletDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println(" do get !!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println(" do post !!!");
    }
}
