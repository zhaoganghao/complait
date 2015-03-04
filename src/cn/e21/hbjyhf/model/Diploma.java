package cn.e21.hbjyhf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Diploma {
	@Id
	@GeneratedValue
	private int did;
	@Column(length=10)
	private String name;
	public Diploma() {
		super();
	}
	public Diploma(String name2) {
		// TODO Auto-generated constructor stub
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
