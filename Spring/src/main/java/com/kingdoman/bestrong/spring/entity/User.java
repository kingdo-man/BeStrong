package com.kingdoman.bestrong.spring.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author kingdoman
 * @date 2020/10/9
 */

public class User implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

	private String name;
	private String password;

	public User() {
		System.out.println("1实例化空参构造");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("2赋值name：" + name);
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("2赋值password：" + password);
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	@Override
	public void setBeanName(String s) {
		System.out.println("3设置bean的名字：" + s);

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// 把对象放进工厂，放进容器
		System.out.println("4设置bean factory：" + beanFactory);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6 属性赋值完成");

	}

	public void myInit() {
		System.out.println("7 自定义初始化执行了 ");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("9 销毁方法执行了");

	}

	public void myDestroy() {
		System.out.println("10 自定义销毁方法执行了");
	}
}
