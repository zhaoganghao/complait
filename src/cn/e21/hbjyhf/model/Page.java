package cn.e21.hbjyhf.model;

import java.util.List;

public class Page {
	
	private List list;
	private int totalpage;  
	
	private int totalrecord;
	private int pagesize = 15;
	
	
	private int pagenum;   
	private int startindex;  
	
	private int startPage;  
	private int endPage;  
	
	private String url;   
	
	public Page(int totalrecord,int pagenum){
		this.totalrecord = totalrecord;
		
		if(this.totalrecord%this.pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize + 1;
		}
		
		this.pagenum = pagenum;  //1
		this.startindex = (this.pagenum-1)*this.pagesize;
		
		
		if(this.totalpage<=10){
			this.startPage = 1;
			this.endPage = this.totalpage;
		}else{
			this.startPage = this.pagenum -4;
			this.endPage = this.pagenum + 5;
			
			if(this.startPage<1){
				this.startPage = 1;
				this.endPage = 10;
			}
			
			if(this.endPage > this.totalpage){
				this.endPage = this.totalpage;
				this.startPage = this.totalpage-9;
			}
			
			
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}




	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}



	public List getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}



	public int getTotalpage() {
		return totalpage;
	}



	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}



	public int getTotalrecord() {
		return totalrecord;
	}



	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}



	public int getPagesize() {
		return pagesize;
	}



	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}



	public int getPagenum() {
		return pagenum;
	}



	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}



	public int getStartindex() {
		return startindex;
	}



	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
	
	
	
	
	
}
