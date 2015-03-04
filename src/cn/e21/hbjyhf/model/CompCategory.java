package cn.e21.hbjyhf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CompCategory {
	@Id
	@GeneratedValue
	private int cid;
	@Column(length=20)
	private String name;
	private int state;//0级，1级，2级，3级，4级
	public CompCategory() {
		super();
	}
	public CompCategory(String name) {
		super();
		this.name = name;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
