package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.Area;

public interface AreaService {
	public Area getAllArea();//从根节点获取说有节点
	public Area getAreaById(int id);//获得详尽的area
	public List<Area> getAreas();//获得所有地区无序的
	public List<Area> getColleges();//获取所有高校
	public List<Area> getCitys();//获得所有市级
	public List<Area> getCountryByPid(int pid);//获得某个市局下面的县
	public List<Area> getCountrys();//获得所有的县
	public void addArea(Area area);
	public void updateArea(Area area);
	public void delArea(Area area);
}
