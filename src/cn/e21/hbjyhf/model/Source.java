package cn.e21.hbjyhf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Source {
	@Id
	@GeneratedValue
	private int sid;
	@Column(length=10)
	private String name;
	
	public Source() {
		super();
	}
	public Source(String name) {
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
