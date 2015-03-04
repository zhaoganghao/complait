package cn.e21.hbjyhf.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.service.CompCategoryService;

public class CompCategoryServiceImpl  extends AbstractService implements CompCategoryService {

	public List<CompCategory> getAllComCategory() {
		Session session =this.sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from CompCategory");
		List<CompCategory> compCategorys=query.list();
		session.getTransaction().commit();
		return compCategorys;
	}

	public CompCategory getComCategoryById(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		CompCategory compCategory=(CompCategory) session.get(CompCategory.class, id);
		session.getTransaction().commit();
		return compCategory;
	}

	public void add(CompCategory category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
	}

	public void del(CompCategory category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
	}

	public void update(CompCategory category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
	}

}
