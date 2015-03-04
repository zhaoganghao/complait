package cn.e21.hbjyhf.service.impl;

import java.util.List;

import org.hibernate.Session;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.UserService;

public class UserServiceImpl extends AbstractService implements UserService {
	
	public Page getUserPage(String pagenum,String url ){
		int totalrecord =this.getTotalrecord();
		
		if(pagenum==null){
			Page page = new Page(totalrecord,1);  
			List list = this.getPageUser(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = this.getPageUser(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}
	private List<User> getPageUser(int startindex,int pagesize){
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		 List<User> users=session.createQuery("from User o ").setFirstResult(startindex).setMaxResults(pagesize).list();
		 session.getTransaction().commit();
		return users;
	}
	private int getTotalrecord(){
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		int totalrecord=((Long)session.createQuery("select count(*) from User").uniqueResult()).intValue();
		session.getTransaction().commit();
		return totalrecord;
	}
	public void addUser(User user) {
		User user2=this.findUser(user.getUsername());
		if(user2!=null){
			throw new RuntimeException("用户存在");
		}
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.persist(user);
		session.getTransaction().commit();
	}
	public User findUser(String username) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user=(User) session.createQuery("from User o where o.username =? ").setParameter(0, username).uniqueResult();
		session.getTransaction().commit();
		return user;		
	}
	public void delUser(User user) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	public void updateUser(User user) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate( user);
		session.getTransaction().commit();
	}
	public List<Area> getArea(){
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Area> list =session.createQuery("select o.aid from User o ").list();
		session.getTransaction().commit();
		return list;
	}
	public User findUserByAid(int aid) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user=(User) session.createQuery("from User o where o.aid.aid =? ").setParameter(0,aid).uniqueResult();
		session.getTransaction().commit();
		return user;
	}
	public List<User> getAllUser() {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<User> users=session.createQuery("from User ").list();
		session.getTransaction().commit();
		return users;
	}
}
