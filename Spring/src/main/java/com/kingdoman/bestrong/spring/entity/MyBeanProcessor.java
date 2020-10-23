package com.kingdoman.bestrong.spring.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author kingdoman
 * @date 2020/10/9
 */

public class MyBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 前置处理" + bean + " ：" + beanName);
        // 多个对象共同属性处理
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("8 后置处理" + bean + " ：" + beanName);

        return bean;
    }
}
