package com.kingdoman.servletdemo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * request response
 */

//@WebServlet(urlPatterns = "/servletdemo2")
@WebServlet("/servletdemo5")
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println(" do get !!!");
        // 获取请求方式
        String method = req.getMethod();
        // 获取虚拟目录
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String requestURI = req.getRequestURI();
        String requestURL = String.valueOf(req.getRequestURL());
        String remoteAddr = req.getRemoteAddr();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println(" do post !!!");
        // 请求中文乱码
        req.setCharacterEncoding("UTF-8");
        // 转发
        req.getRequestDispatcher("/servletdemo4").forward(req, resp);
        // 数据共享
        req.setAttribute("name", "张三");
        req.setAttribute("age", "22");
        req.getAttribute("name");
        req.removeAttribute("name");
        // 获取ServletContext
        ServletContext servletContext = req.getServletContext();
        // 重定向 302 访问缓存 304
        resp.setStatus(302);
        resp.setHeader("location", "/www.baidu.com");
        // 简化重定向代码
        resp.sendRedirect("/www.baidu.com");
        // 乱码
        resp.setContentType("text/html,charset=utf-8");


    }
}
