package com.kingdoman.hiber;

import com.kingdoman.hiber.domain.Student;
import org.hibernate.Session;
import org.junit.Test;

/**
 * @author kingdoman
 * @date 2020/9/27
 */

public class TestDemoCache {
	
	@Test
	public void test1() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// 一级缓存 session级别，在一次请求中共享 默认开启
		
		/**
		 * 二级缓存 sessionFactory级别，整个应用程序共享一个会话工厂，共享一个二级缓存 手动开启
		 *	  分类：类缓存 集合缓存 查询缓存(三级缓存) 时间戳缓存
		 */
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		session.clear();
		Student student1 = session.get(Student.class, 1);
		System.out.println(student1);
		
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
	
}
