package cn.e21.hbjyhf.service.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

abstract class AbstractService {
	protected static SessionFactory sessionFactory;
	static{
		sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	}
}
