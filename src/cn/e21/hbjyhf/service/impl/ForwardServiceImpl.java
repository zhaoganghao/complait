package cn.e21.hbjyhf.service.impl;

import org.hibernate.Session;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.Forward;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.ForwardService;

public class ForwardServiceImpl extends AbstractService implements ForwardService {

	public void add(Forward forward) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(forward);
		session.getTransaction().commit();
	}

	public Forward find(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Forward f=(Forward) session.get(Forward.class, id);
		session.getTransaction().commit();
		return f;
	}

	
}
