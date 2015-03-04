package cn.e21.hbjyhf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@Column(length=20)
	private String username;
	@Column(length=20)
	private String password;
	@Column(length=10)
	private String name;
	@Column(length=15)
	private String phone;
	@Column(length=20)
	private String email;
	@Column(length=50)
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="aid")
	private Area aid;
	
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public User(String username, String password, String name, String phone,
			String email, String address, Area aid) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.aid = aid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Area getAid() {
		return aid;
	}
	public void setAid(Area aid) {
		this.aid = aid;
	}
	
}
