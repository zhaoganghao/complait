package cn.e21.hbjyhf.model;

import java.util.Date;
import java.util.List;

public class Chart {
	private String name;
	private List<Data> datas;
	
	public List<Data> getDatas() {
		return datas;
	}
	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
