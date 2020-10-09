package com.kingdoman.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author kingdoman
 * @date 2020/10/7
 */

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	//表示构造方法私有化，保证单例模式
	private HibernateUtil() {
	}
	
	/**
	 * @return 获取会话工厂
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			//第一步:读取Hibernate的配置文件  hibernamte.cfg.xml文件
			Configuration configure = new Configuration().configure();
			SessionFactory sessionFactory = configure.buildSessionFactory();
			return sessionFactory;
		} else {
			return sessionFactory;
		}
		
	}
}
