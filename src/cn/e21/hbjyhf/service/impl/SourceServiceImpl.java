package cn.e21.hbjyhf.service.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.service.SourceService;

public class SourceServiceImpl extends AbstractService implements SourceService  {
	
	public List<Source> getAllSource(){
		Session session=this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query= session.createQuery("from Source");
		List<Source>  sources=query.list();
		System.out.println(sources.size());
		session.getTransaction().commit();
		return sources;
	}

	public Source getSourceById(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Source source=(Source) session.get(Source.class, id);
		session.getTransaction().commit();
		return source;
	}


	public void add(Source category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
	}

	public void update(Source category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
	}

	public void del(Source category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
	}
}
