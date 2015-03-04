package cn.e21.hbjyhf.model;
//市局转发到县
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Forward {
	@Id
	@GeneratedValue
	private int fid;
	@Column(length = 10)
	private String name;
	@Lob
	private String remarks;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(length = 20)
	private String email;
	@Column(length = 15)
	private String phone;
	@OneToOne
	private Information iid;
	@OneToOne
	private Area aid;
	public Area getAid() {
		return aid;
	}

	public void setAid(Area aid) {
		this.aid = aid;
	}

	public Forward() {
		super();
	}
	
	public Forward(String name, String remarks, Date date, String email,
			String phone, Information iid,Area aid) {
		super();
		this.name = name;
		this.remarks = remarks;
		this.date = date;
		this.email = email;
		this.phone = phone;
		this.iid = iid;
		this.aid=aid;
	}

	public Information getIid() {
		return iid;
	}

	public void setIid(Information iid) {
		this.iid = iid;
	}

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	
	
}
