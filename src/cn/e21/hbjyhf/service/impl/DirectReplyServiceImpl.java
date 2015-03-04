package cn.e21.hbjyhf.service.impl;

import org.hibernate.Session;

import cn.e21.hbjyhf.model.DirectReply;
import cn.e21.hbjyhf.service.DirectReplyService;

public class DirectReplyServiceImpl extends AbstractService implements DirectReplyService {

	public void add(DirectReply directReply) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(directReply);
		session.getTransaction().commit();
	}

	public DirectReply find(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		DirectReply dr=(DirectReply) session.get(DirectReply.class, id);
		session.getTransaction().commit();
		return dr;
	}

	public DirectReply getDirectReplyById(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

}
