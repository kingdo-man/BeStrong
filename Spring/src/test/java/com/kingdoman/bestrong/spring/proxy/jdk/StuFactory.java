package com.kingdoman.bestrong.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StuFactory {

    public static StudentService createdStudentService() {

        final StudentService studentService = new StudentServiceImpl();

        final MyAspect aspect = new MyAspect();

        StudentService proxyInstance = (StudentService) Proxy.newProxyInstance(StuFactory.class.getClassLoader(),
                studentService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aspect.before();
                        Object invoke = method.invoke(studentService, args);
                        aspect.after();
                        return invoke;
                    }
                });

        return proxyInstance;
    }
}
