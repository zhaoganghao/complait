package cn.e21.hbjyhf.service.impl;

import org.hibernate.Session;

import cn.e21.hbjyhf.model.Reply;
import cn.e21.hbjyhf.service.ReplyService;

public class ReplyServiceImpl extends AbstractService implements ReplyService {

	public void add(Reply reply) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(reply);
		session.getTransaction().commit();
	}

	public Reply find(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Reply reply=(Reply) session.get(Reply.class, id);
		session.getTransaction().commit();
		return reply;
	}

	public Reply getReplyById(int aid) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Reply reply=(Reply) session.createQuery("from Reply o where o.iid.aid=?").setParameter(0, aid);
		session.getTransaction().commit();
		return reply;
	}

	

}
