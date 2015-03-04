package cn.e21.hbjyhf.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Area {
	@Id
	@GeneratedValue
	private int aid;
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="pid")
	private Area pid;
	@OneToMany(mappedBy="pid",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private List<Area> children;
	@Column(length=15)
	private String name;
	private int state;//null代表省局，市局，高校//0是省局，1是市局，2是县局，3是高校
	
	public Area() {
		super();
	}
	public Area(Area pid, String name, int state) {
		super();
		this.pid = pid;
		this.name = name;
		this.state = state;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Area getPid() {
		return pid;
	}
	public void setPid(Area pid) {
		this.pid = pid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		if (aid != other.aid)
			return false;
		return true;
	}
	public List<Area> getChildren() {
		return children;
	}
	public void setChildren(List<Area> children) {
		this.children = children;
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
