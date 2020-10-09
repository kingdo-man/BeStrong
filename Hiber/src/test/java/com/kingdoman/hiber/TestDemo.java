package com.kingdoman.hiber;

import com.kingdoman.hiber.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kingdoman
 * @date 2020/9/27
 */

public class TestDemo {
	
	@Test
	public void test1() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		// 保存
		User user = new User();
		user.setUserName("张三");
		user.setPassword("12345678");
		session.saveOrUpdate(user);
		
		// get()查询不存在数据返回null； load() 查询不存在数据报错
		
		/*// update()
		User user = session.get(User.class, 1);
		user.setPassword("xxxx");
		session.saveOrUpdate(user);
		
		// delete User user = session.get(User.class, 4);
		*//*User u3 = new User();
		u2.setId(4);
		session.delete(u3);*/
		
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test2() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// openSession需要自己关闭 currentSession不需要自己关闭
		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		System.out.println(session1.hashCode());
		System.out.println(session2.hashCode());
		Session currentSession1 = sessionFactory.getCurrentSession();
		Session currentSession2 = sessionFactory.getCurrentSession();
		System.out.println(currentSession1.hashCode());
		System.out.println(currentSession2.hashCode());
		session1.close();
		session2.close();
		currentSession1.close();
		currentSession2.close();
		sessionFactory.close();
		
	}
	
	@Test
	public void test3() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		// 分页查询 Query面向数据库 HQL面向对象
		Query query = session.createQuery("FROM User");
		query.setFirstResult(2);
		query.setMaxResults(1);
		List<User> list = query.list();
		list.stream().forEach(user -> System.out.println(user));
		
		// 清理缓存 对象就变成游离/脱管状态 clear清理所有缓存 evict清理指定对象
		session.clear();
		
		// hql查询结果一定会缓存，sql查询不会缓存
		
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test4() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		// persist 瞬时态转持久态：对象保存前不能设置id，否则会报错; 事务内部执行会立即insert，外部不会立即执行insert
		// save 会立即执行inset
		
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test5() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		// 一对多保存
		Customer c = new Customer();
		c.setName("张三");
		Order o1 = new Order();
		Order o2 = new Order();
		o1.setName("order1");
		o2.setName("order2");
		o1.setCustomer(c);
		o2.setCustomer(c);
		Set<Order> set = new HashSet<>();
		set.add(o1);
		set.add(o2);
		c.setOrders(set);
		
		session.saveOrUpdate(c);
		session.save(o1);
		session.save(o2);
		
		// 查询 懒加载
		// 删除 需要去掉约束
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test6() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		// 级联操作
		Customer c = new Customer();
		c.setName("张三级联");
		Order o1 = new Order();
		Order o2 = new Order();
		o1.setName("order1");
		o2.setName("order2");
		o1.setCustomer(c);
		o2.setCustomer(c);
		Set<Order> set = new HashSet<>();
		set.add(o1);
		set.add(o2);
		c.setOrders(set);
		
		session.saveOrUpdate(c);
		
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test7() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		// 多对多联操作
		Student s1 = new Student();
		Student s2 = new Student();
		s1.setName("科比");
		s2.setName("麦迪");
		Course c1 = new Course();
		Course c2 = new Course();
		c1.setName("跳投");
		c2.setName("扣篮");
		
		s1.setCourses(new HashSet<>(Arrays.asList(c1, c2)));
		s2.setCourses(new HashSet<>(Arrays.asList(c1, c2)));
		// 学生inverse="false" 中间表才有数据，inverse="true"中间表无数据；保存对象放弃维护关系中间表才有数据
		session.saveOrUpdate(s1);
		session.saveOrUpdate(s2);
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
