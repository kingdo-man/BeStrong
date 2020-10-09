package com.kingdoman.hiber;

import com.kingdoman.hiber.domain.Address;
import com.kingdoman.hiber.domain.Address1;
import com.kingdoman.hiber.domain.Company;
import com.kingdoman.hiber.domain.Company1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kingdoman
 * @date 2020/9/27
 */

public class TestDemo2 {
	
	Logger logger = LoggerFactory.getLogger(TestDemo2.class);
	
	@Test
	public void test1() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// 类加载策略
		logger.debug("logger debug test !!!!!!!!");
		logger.info("logger info test !!!!!!!!!");
		logger.error("logger error test !!!!!!!!!");
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test2() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Company company = new Company();
		company.setName("测试公司");
		Address address = new Address();
		address.setName("成都市xxxx");
		address.setCompany(company);
		// company.setAddress(address);
		session.saveOrUpdate(company);
		session.saveOrUpdate(address);
		
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test3() {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Company1 company = new Company1();
		company.setName("测试公司");
		Address1 address = new Address1();
		address.setName("成都市xxxx");
		address.setCompany(company);
		// company.setAddress(address);
		session.saveOrUpdate(company);
		session.saveOrUpdate(address);
		
		// cfg配置自动提交后此处可以省略
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
