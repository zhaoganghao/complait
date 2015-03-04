package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ISBNValidator;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.model.Data;
import cn.e21.hbjyhf.model.Diploma;
import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.CompCategoryService;
import cn.e21.hbjyhf.service.DiplomaService;
import cn.e21.hbjyhf.service.InformationService;
import cn.e21.hbjyhf.service.SourceService;
import cn.e21.hbjyhf.web.utils.Period;
import cn.e21.hbjyhf.web.utils.SortTest;

public class ChartAction extends BaseAction {
	private InformationService informationService;
	private AreaService areaService;
	private SourceService sourceService;
	private DiplomaService diplomaService;
	private CompCategoryService compCategoryService;
	public InformationService getInformationService() {
		return informationService;
	}
	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}
	public AreaService getAreaService() {
		return areaService;
	}
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	public SourceService getSourceService() {
		return sourceService;
	}
	public void setSourceService(SourceService sourceService) {
		this.sourceService = sourceService;
	}
	public DiplomaService getDiplomaService() {
		return diplomaService;
	}
	public void setDiplomaService(DiplomaService diplomaService) {
		this.diplomaService = diplomaService;
	}
	public CompCategoryService getCompCategoryService() {
		return compCategoryService;
	}
	public void setCompCategoryService(CompCategoryService compCategoryService) {
		this.compCategoryService = compCategoryService;
	}
	public void list(HttpServletRequest request,// 省级编辑投诉
			HttpServletResponse response) throws ServletException, IOException {
		String aids=request.getParameter("aid");
		String startdates=request.getParameter("startdate");
		String enddates=request.getParameter("enddate");
		Period perid=new Period(startdates,enddates);
		Date startdate=perid.getStart();
		Date enddate=perid.getEnd();
		int aid=0;
		if(aids!=null&&!aids.equals("")){
			aid=Integer.parseInt(aids);
		}
		Area area=areaService.getAreaById(aid);
		String wherejpql=null;
		Object params[]=new Object[2];
		params[0]=startdate;
		params[1]=enddate;
		if(area.getState()==1){//市级
			
			List<Information> informations=new ArrayList<Information>();
			//只下达到县
			for(Area area1:area.getChildren()){
				wherejpql="o.caid.aid = "+area1.getAid()+" and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
				informations.addAll(informationService.findInformation(wherejpql, params));
			}
			//只下到市，同时下到达市县
			wherejpql="o.aid.aid = "+area.getAid()+"  and o.curr_date  between ? and ?";
			informations.addAll(informationService.findInformation(wherejpql, params));
			request.setAttribute("informations", informations);
			System.out.println(informations.size());
			request.getRequestDispatcher("/chart/all_list.jsp").forward(
					request, response);
			return;
		}else if(area.getState()==2){
			List<Information> informations=new ArrayList<Information>();
			//只下达到县的同时到市和县的
			wherejpql= " o.caid.aid = "+area.getAid()+" and ? <= o.curr_date and  o.curr_date < ?";
			informations.addAll(informationService.findInformation(wherejpql, params));
			//只到市，转到县的
			wherejpql= " o.aid.aid = "+area.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid="+area.getAid()+" and ? <= o.curr_date and  o.curr_date < ?";
			informations.addAll(informationService.findInformation(wherejpql, params)); 
			request.setAttribute("informations", informations);
			request.getRequestDispatcher("/chart/country_list.jsp").forward(
					request, response);
			return;
		}else if(area.getState()==3){
			List<Information> informations=null;
			wherejpql="o.aid.aid = "+area.getAid()+" and  ? <= o.curr_date and  o.curr_date < ?";
			informations=informationService.findInformation(wherejpql, params);
			request.setAttribute("informations", informations);
			request.getRequestDispatcher("/chart/college_list.jsp").forward(
					request, response);
			return;
		}
		
		
	}
	public void areaInput(HttpServletRequest request,// 省级编辑投诉
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("area", areaService.getAllArea());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.getRequestDispatcher("/chart/area.jsp").forward(
				request, response);
	}
	public void areaNoMethodInput(HttpServletRequest request,// 省级编辑投诉
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("area", areaService.getAllArea());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.getRequestDispatcher("/chart/areanomethod.jsp").forward(
				request, response);
	}
	public void categoryInput(HttpServletRequest request,// 省级编辑投诉
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/chart/all_category.jsp").forward(
				request, response);
	}
	public void findByArea(HttpServletRequest request,// 按地区查询
			HttpServletResponse response) throws ServletException, IOException {
		//获得参数
		String collegeaidS = request.getParameter("collegeaid");
		String caidS = request.getParameter("caid");
		String aidS = request.getParameter("aid");
		String isreverse = request.getParameter("isreverse");
		String comparefield =request.getParameter("comparefield");
		String startdates = request.getParameter("startdate");
		String enddates = request.getParameter("enddate");
		//获得区域
				int aid = 0;
				int caid=0;
				int collegeaid=0;
				if(aidS!=null&&!"".equals(aidS)){
					aid=Integer.parseInt(aidS);
				}
				if(caidS!=null&&!"".equals(caidS)){
					caid=Integer.parseInt(caidS);
				}
				if(collegeaidS!=null&&!"".equals(collegeaidS)){
					collegeaid=Integer.parseInt(collegeaidS);
				}
				Area area=null;
				Area areaCountry=null;
				Area areaCollege=null;
				if(aid!=0){
					 area=areaService.getAreaById(aid);
				}
				if(caid!=0){
					areaCountry=areaService.getAreaById(caid);
				}
				if(collegeaid!=0){
					areaCollege=areaService.getAreaById(collegeaid);
				}
				//处理时间
				Period period=new Period(startdates, enddates);
				//构造起始和结束时间
				Date startdate = period.getStart();
				Date enddate =period.getEnd();
				//构造参数
				Object params[]=new Object[2];
				params[0]=startdate;
				params[1]=enddate;
				String wherejpql=null;
				Data data=null;
				if(areaCountry!=null){
						//只下达到县的同时到市和县的
						wherejpql= " o.caid.aid = "+areaCountry.getAid()+" and ? <= o.curr_date and  o.curr_date < ?";
						int number1=informationService.getTotalrecord(wherejpql, params);
						//只到市，转到县的
						wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid="+areaCountry.getAid()+" and ? <= o.curr_date and  o.curr_date < ?";
						int number2=informationService.getTotalrecord(wherejpql, params);
						int number=number1+number2;
						
					
						wherejpql= " o.caid.aid = "+areaCountry.getAid()+"  and o.drid is not empty and o.aid is empty and ? <= o.curr_date and  o.curr_date < ?";
						int replyednumber1=informationService.getTotalrecord(wherejpql, params);
						wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid=" +areaCountry.getAid()+"  and o.coid is not empty and ? <= o.curr_date and  o.curr_date < ?";
						int replyednumber2=informationService.getTotalrecord(wherejpql, params);
						int replyednumber=replyednumber1+replyednumber2;
						int noreplynumber=number-replyednumber;
						
						wherejpql= " o.caid.aid = "+areaCountry.getAid()+"  and o.aid is empty and o.drid is not empty and o.limit_time <o.drid.date and ? <= o.curr_date and  o.curr_date < ?";
						int overduenumber1=informationService.getTotalrecord(wherejpql, params);
						wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid=" +areaCountry.getAid()+"  and o.coid is not empty and o.limit_time <o.coid.date and ? <= o.curr_date and  o.curr_date < ?";
						int overduenumber2=informationService.getTotalrecord(wherejpql, params);
						int overduenumber=overduenumber1+overduenumber2;
						
						wherejpql= " o.caid.aid = "+areaCountry.getAid()+"  and o.aid is empty and o.drid is not empty and o.drid.isBoolean = 1 and o.limit_time <o.drid.date and ? <= o.curr_date and  o.curr_date < ?";
						int checknumber1=informationService.getTotalrecord(wherejpql, params);
						wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid=" +areaCountry.getAid()+"  and o.coid is not empty and o.coid.isBoolean = 1 and o.limit_time <o.coid.date and ? <= o.curr_date and  o.curr_date < ?";
						int checknumber2=informationService.getTotalrecord(wherejpql, params);
						int checknumber=checknumber1+checknumber2;
						float checkpercent=0;
						if(number!=0){
							checkpercent=(float)checknumber/(float)number;
						}
						data=new Data(0,areaCountry.getAid(),"", number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,(Date)params[0],(Date)params[1]);
					request.setAttribute("area2",areaCountry);
					
				}else if(area!=null){
						//只下达到县的
						int number1=0;
						for(Area area2:area.getChildren()){
							wherejpql="o.caid.aid = "+area2.getAid()+" and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
							 number1=number1+informationService.getTotalrecord(wherejpql, params);
						}
						//只下到市，同时下到达市县
						wherejpql="o.aid.aid = "+area.getAid()+"  and  ? <= o.curr_date and  o.curr_date < ?";
						int number2=informationService.getTotalrecord(wherejpql, params);
						int number=number1+number2;
						
						int replyednumber1=0;
						for(Area area2:area.getChildren()){
							wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
							replyednumber1=replyednumber1+informationService.getTotalrecord(wherejpql, params);
						}
						wherejpql="o.aid.aid = "+area.getAid()+" and o.rid is not empty and  ? <= o.curr_date and  o.curr_date < ?";
						int replyednumber2=informationService.getTotalrecord(wherejpql,  params);
						int replyednumber=replyednumber1+replyednumber2;
						
						int noreplynumber=number-replyednumber;
						
						int overduenumber1=0;
						for(Area area2:area.getChildren()){
							wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.limit_time <o.drid.date and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
							overduenumber1=overduenumber1+informationService.getTotalrecord(wherejpql, params);
						}
						wherejpql="o.aid.aid = "+area.getAid()+" and o.limit_time <o.rid.date and o.rid is not empty and ? <= o.curr_date and  o.curr_date < ?";
						int overduenumber2=informationService.getTotalrecord(wherejpql,  params);
						int overduenumber=overduenumber1+overduenumber2;
						
						int checknumber1=0;
						for(Area area2:area.getChildren()){
							wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.drid.isBoolean =1  and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
							checknumber1=checknumber1+informationService.getTotalrecord(wherejpql, params);
						}
						wherejpql="o.aid.aid = "+area.getAid()+" and o.rid.isBoolean = 1  and o.rid is not empty and ? <= o.curr_date and  o.curr_date < ?";
						int checknumber2=informationService.getTotalrecord(wherejpql,  params);
						int checknumber=checknumber1+checknumber2;
						
						
						float checkpercent=0;
						if(number!=0){
							checkpercent=(float)checknumber/(float)number;
						}
						data=new Data(0,area.getAid(),area.getName(), number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,(Date)params[0],(Date)params[1]);
						
					request.setAttribute("area2",area);
				}else if(areaCollege!=null){
						wherejpql="o.aid.aid = "+areaCollege.getAid()+" and  ? <= o.curr_date and  o.curr_date < ?";
						int number=informationService.getTotalrecord(wherejpql, params);
						
						wherejpql="o.aid.aid = "+areaCollege.getAid()+" and o.rid is not empty and  ? <= o.curr_date and  o.curr_date < ?";
						int replyednumber=informationService.getTotalrecord(wherejpql, params);
						
						int noreplynumber=number-replyednumber;
						
						wherejpql="o.aid.aid = "+areaCollege.getAid()+" and o.rid is not empty and o.limit_time <o.rid.date and  ? <= o.curr_date and  o.curr_date < ?";
						int overduenumber=informationService.getTotalrecord(wherejpql, params);
						
						wherejpql="o.aid.aid = "+areaCollege.getAid()+"  and o.rid is not empty and o.rid.isBoolean = 1 and  ? <= o.curr_date and  o.curr_date < ?";
						int checknumber=informationService.getTotalrecord(wherejpql, params);
						
						float checkpercent=0;
						if(number!=0){
							checkpercent=(float)checknumber/(float)number;
						}
						data=new Data(0,areaCollege.getAid(),areaCollege.getName(), number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,(Date)params[0],(Date)params[1]);
						
					request.setAttribute("area2",areaCollege);
				}
				
				
				request.setAttribute("startdate", startdate);
				request.setAttribute("enddate", enddate);
				request.setAttribute("area", areaService.getAllArea());
				request.setAttribute("citys", areaService.getCitys());
				request.setAttribute("colleges", areaService.getColleges());
				request.setAttribute("data",data);
				System.out.println("**********************");
				request.getRequestDispatcher("/chart/areanomethod.jsp").forward(
						request, response);
	}
	public void findByArea1(HttpServletRequest request,// 按地区查询
			HttpServletResponse response) throws ServletException, IOException {
		//获得参数
		String collegeaidS = request.getParameter("collegeaid");
		String caidS = request.getParameter("caid");
		String aidS = request.getParameter("aid");
		String month1 = request.getParameter("month1");
		String month2 = request.getParameter("month2");
		String year = request.getParameter("year");
		String isreverse = request.getParameter("isreverse");
		String comparefield =request.getParameter("comparefield");
		Boolean isReverse=true;
		if(isreverse!=null&&!isreverse.equals("")){
			isReverse=Boolean.parseBoolean(isreverse);
		}
		String compareField ="number";
		if(comparefield!=null&&!comparefield.equals("")){
			compareField=comparefield;
		}
				
				
		//构造起始和结束时间的字符串
		String startdates = year+"-"+month1+"-"+"01";
		String enddates = year+"-"+month2+"-"+"01";
		//获得区域
		int aid = 0;
		int caid=0;
		int collegeaid=0;
		if(aidS!=null&&!"".equals(aidS)){
			aid=Integer.parseInt(aidS);
		}
		if(caidS!=null&&!"".equals(caidS)){
			caid=Integer.parseInt(caidS);
		}
		if(collegeaidS!=null&&!"".equals(collegeaidS)){
			collegeaid=Integer.parseInt(collegeaidS);
		}
		Area area=null;
		Area areaCountry=null;
		Area areaCollege=null;
		if(aid!=0){
			 area=areaService.getAreaById(aid);
		}
		if(caid!=0){
			areaCountry=areaService.getAreaById(caid);
		}
		if(collegeaid!=0){
			areaCollege=areaService.getAreaById(collegeaid);
		}
		//处理时间
		Period period=new Period(startdates, enddates);
		//构造起始和结束时间
		Date startdate = period.getStart();
		Date startdate1 = period.getStart();
		Date enddate =Period.getNextMonth(period.getEnd());
		//开始月分，结束月份
		int start=period.getStarMonth();
		int end=period.getEndMonth();
		//构造参数
		Object params[]=new Object[2];
		String wherejpql=null;
		Data data=null;
		List<Data> datas=new ArrayList<Data>();
		if(areaCountry!=null){
			for(int i=start;i<=end;i++){
				//只下达到县的同时到市和县的
				wherejpql= " o.caid.aid = "+areaCountry.getAid()+" and ? <= o.curr_date and  o.curr_date < ?";
				params[0]=startdate;
				int month=startdate.getMonth();
				startdate=Period.getNextMonth(startdate);
				params[1]=startdate;
				int number1=informationService.getTotalrecord(wherejpql, params);
				//只到市，转到县的
				wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid="+areaCountry.getAid()+" and ? <= o.curr_date and  o.curr_date < ?";
				int number2=informationService.getTotalrecord(wherejpql, params);
				int number=number1+number2;
				
			
				wherejpql= " o.caid.aid = "+areaCountry.getAid()+"  and o.drid is not empty and o.aid is empty and ? <= o.curr_date and  o.curr_date < ?";
				int replyednumber1=informationService.getTotalrecord(wherejpql, params);
				wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid=" +areaCountry.getAid()+"  and o.coid is not empty and ? <= o.curr_date and  o.curr_date < ?";
				int replyednumber2=informationService.getTotalrecord(wherejpql, params);
				int replyednumber=replyednumber1+replyednumber2;
				int noreplynumber=number-replyednumber;
				
				wherejpql= " o.caid.aid = "+areaCountry.getAid()+"  and o.aid is empty and o.drid is not empty and o.limit_time <o.drid.date and ? <= o.curr_date and  o.curr_date < ?";
				int overduenumber1=informationService.getTotalrecord(wherejpql, params);
				wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid=" +areaCountry.getAid()+"  and o.coid is not empty and o.limit_time <o.coid.date and ? <= o.curr_date and  o.curr_date < ?";
				int overduenumber2=informationService.getTotalrecord(wherejpql, params);
				int overduenumber=overduenumber1+overduenumber2;
				
				wherejpql= " o.caid.aid = "+areaCountry.getAid()+"  and o.aid is empty and o.drid is not empty and o.drid.isBoolean = 1 and o.limit_time <o.drid.date and ? <= o.curr_date and  o.curr_date < ?";
				int checknumber1=informationService.getTotalrecord(wherejpql, params);
				wherejpql= " o.aid.aid = "+areaCountry.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid=" +areaCountry.getAid()+"  and o.coid is not empty and o.coid.isBoolean = 1 and o.limit_time <o.coid.date and ? <= o.curr_date and  o.curr_date < ?";
				int checknumber2=informationService.getTotalrecord(wherejpql, params);
				int checknumber=checknumber1+checknumber2;
				float checkpercent=0;
				if(number!=0){
					checkpercent=(float)checknumber/(float)number;
				}
				data=new Data(i,areaCountry.getAid(),"", number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,(Date)params[0],(Date)params[1]);
				datas.add(data);
			}
			request.setAttribute("area2",areaCountry);
			
		}else if(area!=null){
			for(int i=start;i<=end;i++){
				params[0]=startdate;
				startdate=Period.getNextMonth(startdate);
				params[1]=startdate;
				//只下达到县的
				int number1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
					 number1=number1+informationService.getTotalrecord(wherejpql, params);
				}
				//只下到市，同时下到达市县
				wherejpql="o.aid.aid = "+area.getAid()+"  and  ? <= o.curr_date and  o.curr_date < ?";
				int number2=informationService.getTotalrecord(wherejpql, params);
				int number=number1+number2;
				
				int replyednumber1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
					replyednumber1=replyednumber1+informationService.getTotalrecord(wherejpql, params);
				}
				wherejpql="o.aid.aid = "+area.getAid()+" and o.rid is not empty and  ? <= o.curr_date and  o.curr_date < ?";
				int replyednumber2=informationService.getTotalrecord(wherejpql,  params);
				int replyednumber=replyednumber1+replyednumber2;
				
				int noreplynumber=number-replyednumber;
				
				int overduenumber1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.limit_time <o.drid.date and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
					overduenumber1=overduenumber1+informationService.getTotalrecord(wherejpql, params);
				}
				wherejpql="o.aid.aid = "+area.getAid()+" and o.limit_time <o.rid.date and o.rid is not empty and ? <= o.curr_date and  o.curr_date < ?";
				int overduenumber2=informationService.getTotalrecord(wherejpql,  params);
				int overduenumber=overduenumber1+overduenumber2;
				
				int checknumber1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.drid.isBoolean =1  and o.aid is empty and  ? <= o.curr_date and  o.curr_date < ?";
					checknumber1=checknumber1+informationService.getTotalrecord(wherejpql, params);
				}
				wherejpql="o.aid.aid = "+area.getAid()+" and o.rid.isBoolean = 1  and o.rid is not empty and ? <= o.curr_date and  o.curr_date < ?";
				int checknumber2=informationService.getTotalrecord(wherejpql,  params);
				int checknumber=checknumber1+checknumber2;
				
				
				float checkpercent=0;
				if(number!=0){
					checkpercent=(float)checknumber/(float)number;
				}
				data=new Data(i,area.getAid(),area.getName(), number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,(Date)params[0],(Date)params[1]);
				datas.add(data);
				
			}
			request.setAttribute("area2",area);
		}else if(areaCollege!=null){
			for(int i=start;i<=end;i++){
				params[0]=startdate;
				startdate=Period.getNextMonth(startdate);
				params[1]=startdate;
				
				wherejpql="o.aid.aid = "+areaCollege.getAid()+" and  ? <= o.curr_date and  o.curr_date < ?";
				int number=informationService.getTotalrecord(wherejpql, params);
				
				wherejpql="o.aid.aid = "+areaCollege.getAid()+" and o.rid is not empty and  ? <= o.curr_date and  o.curr_date < ?";
				int replyednumber=informationService.getTotalrecord(wherejpql, params);
				
				int noreplynumber=number-replyednumber;
				
				wherejpql="o.aid.aid = "+areaCollege.getAid()+" and o.rid is not empty and o.limit_time <o.rid.date and  ? <= o.curr_date and  o.curr_date < ?";
				int overduenumber=informationService.getTotalrecord(wherejpql, params);
				
				wherejpql="o.aid.aid = "+areaCollege.getAid()+"  and o.rid is not empty and o.rid.isBoolean = 1 and  ? <= o.curr_date and  o.curr_date < ?";
				int checknumber=informationService.getTotalrecord(wherejpql, params);
				
				float checkpercent=0;
				if(number!=0){
					checkpercent=(float)checknumber/(float)number;
				}
				data=new Data(i,areaCollege.getAid(),areaCollege.getName(), number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,(Date)params[0],(Date)params[1]);
				datas.add(data);
				
			}
			request.setAttribute("area2",areaCollege);
		}
		
		
		request.setAttribute("startdate", startdate1);
		request.setAttribute("enddate", enddate);
		request.setAttribute("area", areaService.getAllArea());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		SortTest.listSort(datas, compareField, isReverse);
		request.setAttribute("datas",datas);
		
		request.getRequestDispatcher("/chart/area.jsp").forward(
				request, response);
		
	}
	public void query(HttpServletRequest request,// 查看各个类别
			HttpServletResponse response) throws ServletException, IOException {
		String startdates = request.getParameter("startdate");
		String enddates = request.getParameter("enddate");
		String type = request.getParameter("type");
		String isreverse = request.getParameter("isreverse");
		String comparefield =request.getParameter("comparefield");
		Boolean isReverse=true;
		if(isreverse!=null&&!isreverse.equals("")){
			isReverse=Boolean.parseBoolean(isreverse);
		}
		String compareField ="number";
		if(comparefield!=null&&!comparefield.equals("")){
			compareField=comparefield;
		}
				
		//处理时间
		Period period=new Period(startdates, enddates);
		//构造起始和结束时间
		Date startdate = period.getStart();
		Date enddate =period.getEnd();
		Object params[]=new Object[2];
		params[0]=startdate;
		params[1]=enddate;
		if(type!=null&&type.equals("1")){
			Data data=null;
			List<Data> datas=new ArrayList<Data>();
			String wherejpql=null;
			List<Area> list=areaService.getCitys();
			int i=0;
			for(Area area : list){
				//只下达到县的
				int number1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.aid is empty and o.curr_date  between ? and ?";
					 number1=number1+informationService.getTotalrecord(wherejpql, params);
				}
				//只下到市，同时下到达市县
				wherejpql="o.aid.aid = "+area.getAid()+"  and o.curr_date  between ? and ?";
				int number2=informationService.getTotalrecord(wherejpql, params);
				int number=number1+number2;
				
				int replyednumber1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.aid is empty and o.curr_date  between ? and ?";
					replyednumber1=replyednumber1+informationService.getTotalrecord(wherejpql, params);
				}
				wherejpql="o.aid.aid = "+area.getAid()+" and o.rid is not empty and o.curr_date between ? and ?";
				int replyednumber2=informationService.getTotalrecord(wherejpql,  params);
				int replyednumber=replyednumber1+replyednumber2;
				
				int noreplynumber=number-replyednumber;
				
				int overduenumber1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.limit_time <o.drid.date and o.aid is empty and o.curr_date  between ? and ?";
					overduenumber1=overduenumber1+informationService.getTotalrecord(wherejpql, params);
				}
				wherejpql="o.aid.aid = "+area.getAid()+" and o.limit_time <o.rid.date and o.rid is not empty and o.curr_date  between ? and ?";
				int overduenumber2=informationService.getTotalrecord(wherejpql,  params);
				int overduenumber=overduenumber1+overduenumber2;
				
				int checknumber1=0;
				for(Area area2:area.getChildren()){
					wherejpql="o.caid.aid = "+area2.getAid()+" and o.drid is not empty and o.drid.isBoolean =1  and o.aid is empty and o.curr_date  between ? and ?";
					checknumber1=checknumber1+informationService.getTotalrecord(wherejpql, params);
				}
				wherejpql="o.aid.aid = "+area.getAid()+" and o.rid.isBoolean = 1  and o.rid is not empty and o.curr_date  between ? and ?";
				int checknumber2=informationService.getTotalrecord(wherejpql,  params);
				int checknumber=checknumber1+checknumber2;
				
				
				float checkpercent=0;
				if(number!=0){
					checkpercent=(float)checknumber/(float)number;
				}
				i+=1;
				data=new Data(i,area.getAid(),area.getName(), number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,startdate,enddate);
				datas.add(data);
				
			}
			SortTest.listSort(datas, compareField, isReverse);
			request.setAttribute("datas",datas);
			request.getRequestDispatcher("/chart/all_category.jsp").forward(
					request, response);
			return;
			
		}else if(type!=null&&type.equals("2")){
			Data data=null;
			List<Data> datas=new ArrayList<Data>();
			String wherejpql=null;
			List<Area> list=areaService.getCountrys();
			int i=0;
			for(Area area : list){
				//直到县的
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is empty and  o.curr_date  between ? and ?";
				int number1=informationService.getTotalrecord(wherejpql, params);
				//只到市的
				wherejpql="o.aid.aid = "+area.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid = "+area.getAid()+"  and  o.curr_date  between ? and ?";
				int number2=informationService.getTotalrecord(wherejpql, params);
				//到县和市的
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is not empty and  o.curr_date  between ? and ?";
				int number3=informationService.getTotalrecord(wherejpql, params);
				int number=number1+number2 +number3;
				
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is empty and o.drid is not empty and  o.curr_date  between ? and ?";
				int replyednumber1=informationService.getTotalrecord(wherejpql, params);
				wherejpql="o.aid.aid = "+area.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid = "+area.getAid()+" and o.coid is not empty and  o.curr_date  between ? and ?";
				int replyednumber2=informationService.getTotalrecord(wherejpql, params);
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is not empty and o.drid is not empty and  o.curr_date  between ? and ?";
				int replyednumber3=informationService.getTotalrecord(wherejpql, params);
				int replyednumber=replyednumber1+replyednumber2+replyednumber3;
				
				int noreplynumber=number-replyednumber;
				
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is empty and o.drid is not empty and o.limit_time <o.drid.date and  o.curr_date  between ? and ?";
				int overduenumber1=informationService.getTotalrecord(wherejpql, params);
				wherejpql="o.aid.aid = "+area.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid = "+area.getAid()+" and o.coid is not empty  and o.limit_time <o.coid.date and  o.curr_date  between ? and ?";
				int overduenumber2=informationService.getTotalrecord(wherejpql, params);
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is not empty and o.drid is not empty and o.limit_time <o.drid.date and  o.curr_date  between ? and ?";
				int overduenumber3=informationService.getTotalrecord(wherejpql, params);
				int overduenumber=overduenumber1+overduenumber2+overduenumber3;
				
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is empty and o.drid is not empty and o.drid.isBoolean = 1 and  o.curr_date  between ? and ?";
				int checknumber1=informationService.getTotalrecord(wherejpql, params);
				wherejpql="o.aid.aid = "+area.getPid().getAid()+" and o.caid is empty and o.fid.aid.aid = "+area.getAid()+" and o.coid is not empty and o.coid.isBoolean = 1 and o.curr_date  between ? and ?";
				int checknumber2=informationService.getTotalrecord(wherejpql, params);
				wherejpql="o.caid.aid = "+area.getAid()+" and o.aid is not empty and o.drid is not empty and o.drid.isBoolean = 1 and  o.curr_date  between ? and ?";
				int checknumber3=informationService.getTotalrecord(wherejpql, params);
				int  checknumber=checknumber1+checknumber2+checknumber3;
				float checkpercent=0;
				if(number!=0){
					checkpercent=(float)checknumber/(float)number;
				}
				i+=1;
				data=new Data(i,area.getAid(),area.getName(), number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,startdate,enddate);
				datas.add(data);
				
			}
			SortTest.listSort(datas, compareField, isReverse);
			request.setAttribute("datas",datas);
			request.getRequestDispatcher("/chart/all_category.jsp").forward(
					request, response);
			return;
			
		}else if(type!=null&&type.equals("3")){
			Data data=null;
			List<Data> datas=new ArrayList<Data>();
			String wherejpql=null;
			List<Area> list=areaService.getColleges();
			int i=0;
			for(Area area : list){
				wherejpql="o.aid.aid = "+area.getAid()+" and  o.curr_date  between ? and ?";
				int number=informationService.getTotalrecord(wherejpql, params);
				
				wherejpql="o.aid.aid = "+area.getAid()+" and o.rid is not empty and  o.curr_date  between ? and ?";
				int replyednumber=informationService.getTotalrecord(wherejpql, params);
				
				int noreplynumber=number-replyednumber;
				
				wherejpql="o.aid.aid = "+area.getAid()+" and o.rid is not empty and o.limit_time <o.rid.date and  o.curr_date  between ? and ?";
				int overduenumber=informationService.getTotalrecord(wherejpql, params);
				
				wherejpql="o.aid.aid = "+area.getAid()+"  and o.rid is not empty and o.rid.isBoolean = 1 and  o.curr_date  between ? and ?";
				int checknumber=informationService.getTotalrecord(wherejpql, params);
				
				float checkpercent=0;
				if(number!=0){
					checkpercent=(float)checknumber/(float)number;
				}
				i+=1;
				data=new Data(i,area.getAid(),area.getName(), number, replyednumber, noreplynumber, overduenumber, checknumber, checkpercent,startdate,enddate);
				datas.add(data);
				
			}
			SortTest.listSort(datas, compareField, isReverse);
			request.setAttribute("datas",datas);
			request.getRequestDispatcher("/chart/all_category.jsp").forward(
					request, response);
			return;
		}else if(type!=null&&type.equals("4")){
			Data data=null;
			List<Data> datas=new ArrayList<Data>();
			String wherejpql=null;
			List<Source> list=sourceService.getAllSource();
			int i=0;
			for(Source source : list){
				wherejpql="o.sid.sid = "+source.getSid()+" and  o.curr_date  between ? and ?";
				int number=informationService.getTotalrecord(wherejpql, params);
				i+=1;
				data=new Data();
				data.setId(i);
				data.setName(source.getName());
				data.setNumber(number);
				datas.add(data);
				
			}
			SortTest.listSort(datas, compareField, isReverse);
			request.setAttribute("datas",datas);
			request.getRequestDispatcher("/chart/category.jsp").forward(
					request, response);
			return;
			
		}else if(type!=null&&type.equals("5")){
			Data data=null;
			List<Data> datas=new ArrayList<Data>();
			String wherejpql=null;
			List<CompCategory> list=compCategoryService.getAllComCategory();
			int i=0;
			for(CompCategory c : list){
				wherejpql="o.cid.cid = "+c.getCid()+" and  o.curr_date  between ? and ?";
				int number=informationService.getTotalrecord(wherejpql, params);
				i+=1;
				data=new Data();
				data.setId(i);
				data.setName(c.getName());
				data.setNumber(number);
				datas.add(data);
				
			}
			SortTest.listSort(datas, compareField, isReverse);
			request.setAttribute("datas",datas);
			request.getRequestDispatcher("/chart/category").forward(
					request, response);
			return;
		}else if(type!=null&&type.equals("6")){
			Data data=null;
			List<Data> datas=new ArrayList<Data>();
			String wherejpql=null;
			List<Diploma> list=diplomaService.getAllDiploma();
			int i=0;
			for(Diploma diploma : list){
				wherejpql="o.did.did = "+diploma.getDid()+" and  o.curr_date  between ? and ?";
				int number=informationService.getTotalrecord(wherejpql, params);
				i+=1;
				data=new Data();
				data.setId(i);
				data.setName(diploma.getName());
				data.setNumber(number);
				datas.add(data);
				
			}
			SortTest.listSort(datas, compareField, isReverse);
			request.setAttribute("datas",datas);
			request.getRequestDispatcher("/chart/category").forward(
					request, response);
			return;
		}
	}
	
}
