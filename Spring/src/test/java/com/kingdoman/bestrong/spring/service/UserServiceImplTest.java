package com.kingdoman.bestrong.spring.service;

import com.kingdoman.bestrong.spring.entity.Student;
import com.kingdoman.bestrong.spring.entity.User;
import com.kingdoman.bestrong.spring.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * @author kingdoman
 * @date 2020/10/9
 */

public class UserServiceImplTest {

	@Test
	public void addTest() {
		// 旧方法 自己创建
		UserService userService = new UserServiceImpl();
		userService.add();
		// spring 方法从容器获取
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService1 = (UserService) context.getBean("userService");
		userService1.add();
		UserService userService2 = (UserService) context.getBean("userService");
		System.out.println(userService);
		System.out.println(userService1);
		System.out.println(userService2);
	}

	@Test
	public void test01() {
		// spring加载容器的方式
		// 方式一：即时加载对Beanfactoy的扩展
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService) context.getBean("userService");
		/*// 方式二：文件系统路径
		String path = "/Users/tt/IdeaProjects/BeStrong/Spring/src/main/resources/beans.xml";
		ApplicationContext context2 = new FileSystemXmlApplicationContext(path);
		UserService userService2 = (UserService)context2.getBean("userService");
		userService2.add();
		// 方式三：bean工厂(已过时) 延迟加载
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(path));
		UserService userService3 = (UserService)factory.getBean("userService");
		userService3.add();*/
		userService.add();
		System.out.println(userService);
	}

	@Test
	public void testBeanLife() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// spring加载容器的方式
		// 方式一：即时加载对Beanfactoy的扩展
		ApplicationContext context = new ClassPathXmlApplicationContext("beansLife.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
		context.getClass().getMethod("close").invoke(context);
	}

	@Test
	public void test02() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student student = (Student) context.getBean("student");
		System.out.println(student);
	}


	@Test
	public void test03() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		UserServiceImpl userService = context.getBean(UserServiceImpl.class);
		userService.add();
	}
}
