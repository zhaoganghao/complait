package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.model.Diploma;
import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.CompCategoryService;
import cn.e21.hbjyhf.service.DiplomaService;
import cn.e21.hbjyhf.service.InformationService;
import cn.e21.hbjyhf.service.ReplyService;
import cn.e21.hbjyhf.service.SourceService;

public class ProvinceAction extends BaseAction {
	private InformationService informationService;
	private AreaService areaService;
	private SourceService sourceService;
	private DiplomaService diplomaService;
	private CompCategoryService compCategoryService;
	private ReplyService replyService;

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
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

	public InformationService getInformationService() {
		return informationService;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public void noReply(HttpServletRequest request,// 市未回复
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.aid is not empty and o.caid is  empty and o.rid is  empty and o.aid.state=1  ";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "noReply");
		request.setAttribute("pagetitle", "市未回复");
		request.getRequestDispatcher("/information/city_list.jsp").forward(request,
				response);
	}

	public void replyed(HttpServletRequest request,// 市已回复
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.aid is not empty and o.caid is  empty and o.rid is not empty and o.aid.state=1 ";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "replyed");
		request.setAttribute("pagetitle", "市已回复");
		request.getRequestDispatcher("/information/city_list.jsp").forward(request,
				response);
	}

	public void overdue(HttpServletRequest request,// 市逾期回复的
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.aid is not empty and o.caid is  empty and o.rid is not empty and o.aid.state=1 ";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		List<Information> data = page.getList();
		if (data.size() > 0) {
			for (int i = 0; i < data.size(); i++) {
				Information infor = data.get(i);
				Date limit_date = null;
				Date reply_date = null;
				limit_date = infor.getLimit_time();
				reply_date = infor.getRid().getDate();
				Calendar limit_date1 = Calendar.getInstance();
				Calendar reply_date1 = Calendar.getInstance();
				if (limit_date != null)
					limit_date1.setTime(limit_date);
				if (reply_date != null)
					reply_date1.setTime(reply_date);
				if (limit_date1.after(reply_date1)) {
					data.remove(infor);
				}

			}
		}
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "overdue");
		request.setAttribute("pagetitle", "市逾期回复的");
		request.getRequestDispatcher("/information/city_list.jsp").forward(request,
				response);
	}

	public void noCountryReply(HttpServletRequest request,// 县未回复
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.caid is not empty and o.aid is empty and o.drid is  empty  ";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "noCountryReply");
		request.setAttribute("pagetitle", "县未回复");
		request.getRequestDispatcher("/information/country_list.jsp").forward(request,
				response);
	}

	public void countryReplyed(HttpServletRequest request,// 县已回复
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.caid is not empty and o.aid is empty and o.drid is not empty  ";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "countryReplyed");
		request.setAttribute("pagetitle", "县已回复");
		request.getRequestDispatcher("/information/country_list.jsp").forward(request,
				response);
	}

	public void countryOverdue(HttpServletRequest request,// 县逾期回复的
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.caid is not empty and o.aid is empty and o.drid is not empty  ";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		List<Information> data = page.getList();
		if (data.size() > 0) {
			for (int i = 0; i < data.size(); i++) {
				Information infor = data.get(i);
				Date limit_date = null;
				Date reply_date = null;
				limit_date = infor.getLimit_time();
				reply_date = infor.getDrid().getDate();
				Calendar limit_date1 = Calendar.getInstance();
				Calendar reply_date1 = Calendar.getInstance();
				if (limit_date != null)
					limit_date1.setTime(limit_date);
				if (reply_date != null)
					reply_date1.setTime(reply_date);
				if (limit_date1.after(reply_date1)) {
					data.remove(infor);
				}

			}
		}
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "countryOverdue");
		request.setAttribute("pagetitle", "县逾期回复的");
		request.getRequestDispatcher("/information/country_list.jsp").forward(request,
				response);
	}

	public void noCollegeReply(HttpServletRequest request,// 高校未回复
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.aid is not empty and o.aid.state=3 and o.rid is empty";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "noCollegeReply");
		request.setAttribute("pagetitle", "高校未回复");
		request.getRequestDispatcher("/information/city_list.jsp").forward(request,
				response);
	}

	public void collegeReplyed(HttpServletRequest request,// 高校已回复
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.aid is not empty and o.aid.state=3 and o.rid is not empty ";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "collegeReplyed");
		request.setAttribute("pagetitle", "高校已回复");
		request.getRequestDispatcher("/information/city_list.jsp").forward(request,
				response);
	}

	public void collegeOverdue(HttpServletRequest request,// 高校逾期回复的
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.aid is not empty and o.aid.state=3 and o.rid is not empty";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		List<Information> data = page.getList();
		if (data.size() > 0) {
			for (int i = 0; i < data.size(); i++) {
				Information infor = data.get(i);
				Date limit_date = null;
				Date reply_date = null;
				limit_date = infor.getLimit_time();
				reply_date = infor.getRid().getDate();
				Calendar limit_date1 = Calendar.getInstance();
				Calendar reply_date1 = Calendar.getInstance();
				if (limit_date != null)
					limit_date1.setTime(limit_date);
				if (reply_date != null)
					reply_date1.setTime(reply_date);
				if (limit_date1.after(reply_date1)) {
					data.remove(infor);
				}

			}
		}
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "collegeOverdue");
		request.setAttribute("pagetitle", "县逾期回复的");
		request.getRequestDispatcher("/information/city_list.jsp").forward(request,
				response);
	}

	public void cityAndCountry(HttpServletRequest request,// 市县回复的
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String wherejpql = "o.aid is not empty and o.caid is not empty";
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(wherejpql,
				pagenum, null, request.getContextPath() + "/" + "Servlet/"
						+ servletName);
		List<Information> data = page.getList();
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("page", page);
		request.setAttribute("methodname", "collegeOverdue");
		request.setAttribute("pagetitle", "县逾期回复的");
		request.getRequestDispatcher("/information/all_list.jsp").forward(request,
				response);
	}

	public void getInformation(HttpServletRequest request,// 获得详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String iids = request.getParameter("iid");
		int iid = Integer.parseInt(iids);
		Information information = informationService.getInformationById(iid);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("area", areaService.getAllArea());
		request.setAttribute("information", information);
		request.getRequestDispatcher("/information/infor.jsp").forward(request,
				response);
	}

	public void query(HttpServletRequest request,// 查询
			HttpServletResponse response) throws ServletException, IOException {
		// 获得参数
		String collegeaidS = request.getParameter("collegeaid");
		String caidS = request.getParameter("caid");
		String aidS = request.getParameter("aid");
		String didS = request.getParameter("did");
		String cidS = request.getParameter("cid");
		String sidS = request.getParameter("sid");
		// 获得区域
		int aid = 0;
		int caid = 0;
		int collegeaid = 0;
		if (aidS != null && !"".equals(aidS)) {
			aid = Integer.parseInt(aidS);
		}
		if (caidS != null && !"".equals(caidS)) {
			caid = Integer.parseInt(caidS);
		}
		if (collegeaidS != null && !"".equals(collegeaidS)) {
			collegeaid = Integer.parseInt(collegeaidS);
		}
		Area area = null;
		Area areaCountry = null;
		Area areaCollege = null;
		if (aid != 0) {
			area = areaService.getAreaById(aid);
		}
		if (caid != 0) {
			areaCountry = areaService.getAreaById(caid);
		}
		if (collegeaid != 0) {
			areaCollege = areaService.getAreaById(collegeaid);
		}

		String datestarts = request.getParameter("datestart");
		String dateends = request.getParameter("dateend");
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		Date datestart = null;
		Date dateend = null;
		try {
			if (datestarts != null && !"".equals(datestarts.trim())) {
				datestart = dateformat.parse(datestarts);
			}
			if (dateends != null && !"".equals(dateends.trim())) {
				dateend = dateformat.parse(dateends);
			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println("结束");
			e1.printStackTrace();
		}
		int did = 0;
		int sid = 0;
		int cid = 0;
		CompCategory compCategory = null;
		Diploma diploma = null;
		Source source = null;
		try {
			if (didS==null||"".equals(didS.trim())) {
				diploma = null;
			} else {
				did = Integer.parseInt(didS);
				diploma = diplomaService.getDiplomById(did);
			}
			if (aidS==null||"".equals(aidS.trim())) {
				area = null;
			} else {
				aid = Integer.parseInt(aidS);
				area = areaService.getAreaById(aid);
			}
			if (cidS==null||"".equals(cidS.trim())) {
				compCategory = null;
			} else {
				cid = Integer.parseInt(cidS);
				compCategory = compCategoryService.getComCategoryById(cid);
			}

			if (sidS==null||"".equals(sidS.trim())) {
				source = null;
			} else {
				sid = Integer.parseInt(sidS);
				source = sourceService.getSourceById(sid);
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String pagenum = request.getParameter("pagenum");

		StringBuffer wherejpql = new StringBuffer();
		List list = new ArrayList();
		if (area != null&&areaCountry==null ) {
			wherejpql.append("o.aid = ?   and ");// or ( o.aid is empty and o.caid.pid.aid is "+area.getAid()+" )
			list.add(area);
		} else if (areaCountry != null) {
			wherejpql.append("o.caid = ? and ");
			list.add(areaCountry);
		} else if (areaCollege != null) {
			wherejpql.append("o.aid = ? and ");
			list.add(areaCollege);
		}
		
		if (diploma != null) {

			wherejpql.append("o.did = ? and ");
			list.add(diploma);

		}
		if (compCategory != null) {

			wherejpql.append("o.cid = ? and ");
			list.add(compCategory);

		}
		if (source != null) {

			wherejpql.append("o.sid = ? and");
			list.add(source);

		}
		if (datestart != null && dateend != null) {

			wherejpql.append("o.curr_date between  ? and ? and ");
			list.add(datestart);
			list.add(dateend);

		}
		int index = wherejpql.lastIndexOf("and");

		if (index > 0) {
			wherejpql = new StringBuffer(wherejpql.substring(0, index));
		}
		Object[] params = new ArrayList(list).toArray();
		String servletName = this.getServletName();
		Page page = (Page) informationService.getInformationPage(
				wherejpql.toString(), pagenum, params, request.getContextPath()
						+ "/" + "Servlet/" + servletName);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.setAttribute("methodname", "query");
		request.setAttribute("pagetitle", "查询页面");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/information/list.jsp").forward(request,
				response);
	}
}
