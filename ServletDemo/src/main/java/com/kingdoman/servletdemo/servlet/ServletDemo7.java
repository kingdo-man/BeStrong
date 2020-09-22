package com.kingdoman.servletdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Cookie Session
 */

//@WebServlet(urlPatterns = "/servletdemo2")
@WebServlet("/servletdemo7")
public class ServletDemo7 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        Cookie c = new Cookie("name", "msg");
        // 服务器共享
        c.setPath("/");
        // 域名共享 一级域名相同
        c.setDomain("baidu.com");

        // cookie 存储于浏览器，不太安全，且数据大小有限制，一般同一域名下4kb，总cookie个数也有限制 存储少量不太重要的数据
        // ==============================================================================
        HttpSession session = req.getSession();
        session.setAttribute("name", "value");
        // session 销毁
        session.invalidate();
        // 关闭服务器或者设置过期时间
        /**
         * session 可以存储任意数据类型，任意大小的数据
         */
    }
}
