package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Page;

public interface InformationService {

	public void addInformation(Information information);

	public void updateInformation(Information info);

	public void delInformations(String[] ids);
	public Information getInformationById(int id);
	public Information getInformationByAid(int aid);
	public Information getInformationByCaid(int caid);
	public Page getInformationPage(String wherejpql,String pagenum,Object[] params,String url );
	public  int getTotalrecord(String wherejpql,Object[] params);
	public List<Information> findInformation(String wherejpql,Object params[]);
	
}
