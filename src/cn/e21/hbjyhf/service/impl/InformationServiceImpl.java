package cn.e21.hbjyhf.service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.e21.hbjyhf.model.Chart;
import cn.e21.hbjyhf.model.Diploma;
import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.InformationService;

public class InformationServiceImpl extends AbstractService implements InformationService {

	public void addInformation(Information information) {
		System.out.println(information.getContent());
		// TODO Auto-generated method stub
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(information);
		session.getTransaction().commit();
	}

	public void updateInformation(Information info) {
		// TODO Auto-generated method stub
		
	}

	public void delInformations(String[] ids) {
		// TODO Auto-generated method stub
		
	}

	

	

	public Information getInformationById(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Information information=(Information) session.get(Information.class, id);
		session.getTransaction().commit();
		return information;
	}

	
	public Page getInformationPage(String wherejpql,String pagenum, Object[] params,String url ){//获得未回复的内容
		int totalrecord =this.getTotalrecord( wherejpql,params);
		
		if(pagenum==null){
			Page page = new Page(totalrecord,1);  
			List<Information> list = this.findInformation(wherejpql,params,page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List<Information> list =this.findInformation(wherejpql,params,page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}
	private List<Information> findInformation(String wherejpql,Object[] params,int startindex,int pagesize) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query =session.createQuery("from Information o "+(wherejpql==null || "".equals(wherejpql.trim())? "": "where "+ wherejpql)+ " order by o.curr_date desc");
			setQueryParams(query, params);
		List<Information> informations=query.setMaxResults(pagesize).setFirstResult(startindex).list();
		session.getTransaction().commit();
		return informations;
	}
	public int getTotalrecord(String wherejpql,Object[] params){//查找数量
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("select count(*) from Information o "+(wherejpql==null || "".equals(wherejpql.trim())? "": " where "+ wherejpql));
		setQueryParams(query, params);
		int totalrecord=((Long)query.uniqueResult()).intValue();
		session.getTransaction().commit();
		return totalrecord;
	}

	private void setQueryParams(Query query, Object[] queryParams) {
		
		if(queryParams!=null && queryParams.length>0){
			for(int i=0; i<queryParams.length; i++){
				query.setParameter(i, queryParams[i]);
			}
		}
		
	}

	public List<Information> findInformation(String wherejpql, Object[] params) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query =session.createQuery("from Information o "+(wherejpql==null || "".equals(wherejpql.trim())? "": "where "+ wherejpql)+ " order by o.curr_date desc");
			setQueryParams(query, params);
		List<Information> informations=query.list();
		session.getTransaction().commit();
		return informations;
	}

	public Information getInformationByAid(int aid) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Information information=(Information) session.createQuery("from Information o where o.aid = "+aid).uniqueResult();
		session.getTransaction().commit();
		return information;
	}

	public Information getInformationByCaid(int caid) {
		Session session =this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Information information=(Information) session.createQuery("from Information o where o.caid = "+caid).uniqueResult();
		session.getTransaction().commit();
		return information;
	}




	}
