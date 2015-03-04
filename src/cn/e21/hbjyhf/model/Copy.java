package cn.e21.hbjyhf.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Copy {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private CompCategory cid;
	@ManyToOne
	@JoinColumn(name = "aid")
	private Area aid;
	@ManyToOne
	@JoinColumn(name = "caid")
	private Area caid;
	
	@ManyToOne
	@JoinColumn(name = "sid")
	private Source sid;
	@ManyToOne
	@JoinColumn(name = "did")
	private Diploma did;
	
	

	
	@Column(length = 8)
	private String encode;
	@Lob
	private String content;
	@Column(length = 50)
	private String ifrom;
	@Column(length = 200)
	private String remarks;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date curr_date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date limit_time;
	@Column(length = 5)
	private String operater;
	@Column(length = 40)
	private String department;
	@Column(length = 15)
	private String replyphone;
	@Column(length = 20)
	private String replyemail;
	
	public String getReplyemail() {
		return replyemail;
	}
	public void setReplyemail(String replyemail) {
		this.replyemail = replyemail;
	}
	public Copy() {
		super();
	}
	public Copy(int id, CompCategory cid, Area aid, Area caid, Source sid,
			Diploma did, String encode, String content, String ifrom,
			String remarks, Date curr_date, Date limit_time, String operater,
			String department, String replyphone, String replyemail) {
		super();
		this.id = id;
		this.cid = cid;
		this.aid = aid;
		this.caid = caid;
		this.sid = sid;
		this.did = did;
		this.encode = encode;
		this.content = content;
		this.ifrom = ifrom;
		this.remarks = remarks;
		this.curr_date = curr_date;
		this.limit_time = limit_time;
		this.operater = operater;
		this.department = department;
		this.replyphone = replyphone;
		this.replyemail = replyemail;
	}
	//提交市县
	public Copy(CompCategory cid, Area aid, Area caid, Source sid,
			Diploma did, String encode, String content, String ifrom,
			String remarks, Date curr_date, Date limit_time, String operater,
			String replyphone,String department,String replyemail) {
		super();
		this.cid = cid;
		this.aid = aid;
		this.caid = caid;
		this.sid = sid;
		this.did = did;
		this.encode = encode;
		this.content = content;
		this.ifrom = ifrom;
		this.remarks = remarks;
		this.curr_date = curr_date;
		this.limit_time = limit_time;
		this.operater = operater;
		this.replyphone = replyphone;
		this.department=department;
		this.replyemail=replyemail;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Area getCaid() {
		return caid;
	}
	public void setCaid(Area caid) {
		this.caid = caid;
	}
	public CompCategory getCid() {
		return cid;
	}
	public void setCid(CompCategory cid) {
		this.cid = cid;
	}
	public Area getAid() {
		return aid;
	}
	public void setAid(Area aid) {
		this.aid = aid;
	}
	public Source getSid() {
		return sid;
	}
	public void setSid(Source sid) {
		this.sid = sid;
	}
	public Diploma getDid() {
		return did;
	}
	public void setDid(Diploma did) {
		this.did = did;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIfrom() {
		return ifrom;
	}
	public void setIfrom(String ifrom) {
		this.ifrom = ifrom;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCurr_date() {
		return curr_date;
	}
	public void setCurr_date(Date curr_date) {
		this.curr_date = curr_date;
	}
	public Date getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(Date limit_time) {
		this.limit_time = limit_time;
	}
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public String getReplyphone() {
		return replyphone;
	}
	public void setReplyphone(String replyphone) {
		this.replyphone = replyphone;
	}


}
