package com.kingdoman.bestrong.spring.proxy.jdk;

import com.kingdoman.bestrong.spring.proxy.cglib.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactory {

    public static StudentService createdStudentService() {

        final StudentService studentService = new StudentServiceImpl();

        final MyAspect aspect = new MyAspect();

        StudentService proxyInstance = (StudentService) Proxy.newProxyInstance(MyFactory.class.getClassLoader(),
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

    public static UserService createdUserServiceCglib() {

        final UserService userService = new UserService();

        final MyAspect aspect = new MyAspect();

        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                aspect.before();
                // 下面两行代码作用都是放行 proxy是UserService的子类
                //Object invoke = method.invoke(userService, args);
                Object invoke = methodProxy.invokeSuper(proxy, args); //  解耦合,不直接使用UserService
                aspect.after();

                return invoke;
            }
        });

        return (UserService) enhancer.create();
    }
}
