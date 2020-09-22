package com.kingdoman.servletdemo.filterandlistener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter:用于完成一些通用的操作
 * 实现：
 * 1.实现一个类实现Filter接口
 * 2.复写方法
 * 3.配置拦截路径
 * 拦截路径配置：
 * 1.具体资源路径： /index.jsp
 * 2.拦截目录： /uss/*
 * 3.后缀名拦截： *.jsp
 * 4.拦截所有资源： /*
 * 拦截方式配置：资源被访问的方式
 * 1.注解配置：设置dispatcherType属性
 * REQUEST:默认的，浏览器直接访问
 * FORWARD：转发访问
 * INCLUDE：包含访问
 * ERROR：错误跳转
 * ASYNC：异步访问
 * 2.web.xml：<dispatcher></dispatcher> 值同上
 * 多个过滤器执行顺序
 * 注解：按照类名的字符串比较大熊啊，小的先执行
 * web.xml：谁定义的在上面谁先执行
 */

// 拦截所有的路径
//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
@WebFilter(value = "/usr", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class ServletDemo8Filter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter is here !!!");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

