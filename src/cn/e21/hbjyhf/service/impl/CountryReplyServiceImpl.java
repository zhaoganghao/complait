package cn.e21.hbjyhf.service.impl;

import org.hibernate.Session;

import cn.e21.hbjyhf.model.CountryReply;
import cn.e21.hbjyhf.model.Reply;
import cn.e21.hbjyhf.service.CountryReplyService;

public class CountryReplyServiceImpl extends AbstractService implements CountryReplyService {

	public void add(CountryReply reply) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(reply);
		session.getTransaction().commit();
	}

	public CountryReply find(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		CountryReply reply=(CountryReply) session.get(CountryReply.class, id);
		session.getTransaction().commit();
		return reply;
	}

	public CountryReply getCountryReplyById(int aid) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		CountryReply reply=(CountryReply) session.createQuery("from CountryReply o where o.iid.aid=?").setParameter(0, aid);
		session.getTransaction().commit();
		return reply;
	}

	

}
