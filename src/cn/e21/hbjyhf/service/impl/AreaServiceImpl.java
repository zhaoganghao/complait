package cn.e21.hbjyhf.service.impl;

import java.util.List;

import org.hibernate.Session;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.service.AreaService;

public class AreaServiceImpl extends AbstractService implements AreaService {

	public Area getAllArea() {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Area area=(Area) session.createQuery("from Area o where o.aid=1").uniqueResult();
		session.getTransaction().commit();
		return area;
	}
	public Area getAreaById(int id){
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Area area=(Area) session.get(Area.class, id);
		session.getTransaction().commit();
		return area;
	}
	public List<Area> getAreas() {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Area> areas=session.createQuery("from Area").list();
		session.getTransaction().commit();
		return areas;
	}
	public List<Area> getColleges() {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Area> areas=session.createQuery("from Area o where o.state=3").list();
		session.getTransaction().commit();
		return areas;
	}
	public List<Area> getCitys() {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Area> areas=session.createQuery("from Area o where o.state=1").list();
		session.getTransaction().commit();
		return areas;
	}
	public List<Area> getCountryByPid(int pid) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Area> areas=session.createQuery("from Area o where o.pid.aid = "+pid ).list();
		session.getTransaction().commit();
		return areas;
	}
	public List<Area> getCountrys() {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Area> areas=session.createQuery("from Area o where o.state= 2" ).list();
		session.getTransaction().commit();
		return areas;
	}
	public void addArea(Area area) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(area);
		session.getTransaction().commit();
	}
	public void updateArea(Area area) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(area);
		session.getTransaction().commit();
	}
	public void delArea(Area area) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(area);
		session.getTransaction().commit();
	}
	
}
