package com.kingdoman.bestrong.spring.proxy.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Bingabing
 */

@Component
@Aspect
public class MyAspectAnnotation {

    /**
     * 定义公共切入点
     */
    @Pointcut("execution(* com.kingdoman.bestrong.spring.proxy.spring.*Impl.*(..))")
    private void myPointCut() {
    }

    // @Before("execution(* com.kingdoman.bestrong.spring.proxy.spring.*Impl.*(..))")
    public void before(JoinPoint p) {
        System.out.println("annotation before has been invoked !!!!" + p.getSignature().getName());
    }

    // @After("myPointCut()")
    public void after(JoinPoint p) {
        System.out.println("annotation after has been invoked !!!!" + p.getSignature().getName());
    }

    @Around(value = "myPointCut()")
    public Object around(ProceedingJoinPoint p) throws Throwable {
        System.out.println("环绕前置" + p.getSignature().getName());
        Object proceed = p.proceed();
        System.out.println("环绕后置" + p.getSignature().getName());
        return proceed;
    }

    @AfterThrowing(pointcut = "myPointCut()", throwing = "t")
    public void myException(JoinPoint p, Throwable t) {
        System.out.println("my exception !!!" + p.getSignature().getName() + " exception:" + t.getMessage());
    }

    @AfterReturning(pointcut = "myPointCut()", returning = "obj")
    public void myFinal(JoinPoint p, Object obj) {
        // obj为service方法的返回值
        System.out.println("my Final !!!" + p.getSignature().getName());
        System.out.println("返回值：" + obj);
    }
}
