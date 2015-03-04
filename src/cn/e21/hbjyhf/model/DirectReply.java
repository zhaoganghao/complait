package cn.e21.hbjyhf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//县直接回复省
@Entity
public class DirectReply {
	@Id
	@GeneratedValue
	private int drid;
	@Lob
	private String content;
	@Column(name = "isboolean")
	private int isBoolean;// 1属实，0不属实
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(length = 10)
	private String name;
	@Column(length = 15)
	private String phone;
	@Column(length = 30)
	private String email;
	@OneToOne
	private Information iid;
	public Information getIid() {
		return iid;
	}
	public void setIid(Information iid) {
		this.iid = iid;
	}
	public int getDrid() {
		return drid;
	}
	public void setDrid(int drid) {
		this.drid = drid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsBoolean() {
		return isBoolean;
	}
	public void setIsBoolean(int isBoolean) {
		this.isBoolean = isBoolean;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public DirectReply() {
		super();
	}
	public DirectReply(String content, int isBoolean, Date date, String name,
			String phone, String email, Information iid) {
		super();
		this.content = content;
		this.isBoolean = isBoolean;
		this.date = date;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.iid = iid;
	}
	
}
