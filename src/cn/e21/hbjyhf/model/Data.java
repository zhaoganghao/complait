package cn.e21.hbjyhf.model;

import java.util.Date;

public class Data  {
	private Integer id;
	private Integer aid;
	private String name;
	private Integer number;
	private Integer replyednumber;
	private Integer noreplynumber;
	private Integer overduenumber;
	private Integer checknumber;
	private Float checkpercent;
	private String label;
	private Date startdate;
	private Date enddate;
	public Data() {
		super();
	}
	public Data(int id,int aid,String name, int number, int replyednumber, int noreplynumber,
			int overduenumber, int checknumber, float checkpercent,Date startdate,Date enddate) {
		super();
		this.aid=aid;
		this.id=id;
		this.name = name;
		this.number = number;
		this.replyednumber = replyednumber;
		this.noreplynumber = noreplynumber;
		this.overduenumber = overduenumber;
		this.checknumber = checknumber;
		this.checkpercent = checkpercent;
		this.startdate=startdate;
		this.enddate=enddate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getReplyednumber() {
		return replyednumber;
	}
	public void setReplyednumber(Integer replyednumber) {
		this.replyednumber = replyednumber;
	}
	public Integer getNoreplynumber() {
		return noreplynumber;
	}
	public void setNoreplynumber(Integer noreplynumber) {
		this.noreplynumber = noreplynumber;
	}
	public Integer getOverduenumber() {
		return overduenumber;
	}
	public void setOverduenumber(Integer overduenumber) {
		this.overduenumber = overduenumber;
	}
	public Integer getChecknumber() {
		return checknumber;
	}
	public void setChecknumber(Integer checknumber) {
		this.checknumber = checknumber;
	}
	public Float getCheckpercent() {
		return checkpercent;
	}
	public void setCheckpercent(Float checkpercent) {
		this.checkpercent = checkpercent;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
}
