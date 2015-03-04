package cn.e21.hbjyhf.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.model.Copy;
import cn.e21.hbjyhf.service.CopyService;

public class CopyServiceImpl extends AbstractService implements CopyService {

	public void add(Copy copy) {
		Session session =this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(copy);
		session.getTransaction().commit();
	}

	public void update(Copy copy) {
		Session session =this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(copy);
		session.getTransaction().commit();
	}

	public void del(Copy copy) {
		Session session =this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(copy);
		session.getTransaction().commit();
	}

	public Copy getCopyById(int id) {
		Session session =this.sessionFactory.openSession();
		session.beginTransaction();
		Copy copy = (Copy) session.get(Copy.class, id);
		session.getTransaction().commit();
		return copy;
	}

	public List<Copy> getCopys() {
		Session session =this.sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Copy");
		List<Copy> copys=query.list();
		return copys;
	}

}
