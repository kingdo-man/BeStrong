package com.kingdoman.bestrong.spring.proxy.jdk;

public class MyAspect {

    public void before() {
        System.out.println("before has been invoked !!!!");
    }

    public void after() {
        System.out.println("after has been invoked !!!!");
    }
}
