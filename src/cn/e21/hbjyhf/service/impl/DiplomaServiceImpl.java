package cn.e21.hbjyhf.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.Diploma;
import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.service.DiplomaService;

public class DiplomaServiceImpl extends AbstractService implements DiplomaService {

	public List<Diploma> getAllDiploma() {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Diploma a  ");
		List<Diploma> diplomas=query.list();
		session.getTransaction().commit();
		return diplomas;
	}

	public Diploma getDiplomById(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Diploma diploma=(Diploma) session.get(Diploma.class, id);
		session.getTransaction().commit();
		return diploma;
	}

	public void add(Diploma category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
	}

	public void update(Diploma category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
	}

	public void del(Diploma category) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
	}

}
