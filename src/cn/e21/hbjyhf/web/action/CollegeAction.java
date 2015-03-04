package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.Reply;
import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.CountryReplyService;
import cn.e21.hbjyhf.service.InformationService;
import cn.e21.hbjyhf.service.ReplyService;

public class CollegeAction extends BaseAction {
	private ReplyService replyService;
	private InformationService informationService;
	private AreaService areaService;
	private CountryReplyService countryReplyService;
	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}



	public CountryReplyService getCountryReplyService() {
		return countryReplyService;
	}

	public void setCountryReplyService(CountryReplyService countryReplyService) {
		this.countryReplyService = countryReplyService;
	}

	public InformationService getInformationService() {
		return informationService;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/country/index.jsp").forward(request,
				response);
		
	}

	public void execute2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Page page = null;
		String wherejpql = " o.aid.aid= " +user.getAid().getAid();
		String servletName = this.getServletName();
		page = (Page) informationService.getInformationPage(wherejpql.toString(), pagenum,
				null, request.getContextPath()+ "/" + "Servlet/" + servletName);
		request.setAttribute("page", page);
		request.setAttribute("methodname", "execute2");
		request.getRequestDispatcher("/college/list.jsp").forward(request,
				response);
	}

	public void getInformation(HttpServletRequest request,// 获得详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String iids = request.getParameter("iid");
		int iid = Integer.parseInt(iids);
		Information information = informationService.getInformationById(iid);
		request.setAttribute("information", information);
		request.getRequestDispatcher("/college/infor.jsp").forward(request,
				response);
	}

	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String iid = request.getParameter("iid");

		request.setAttribute("iid", iid);
		request.getRequestDispatcher("/college/add_input.jsp").forward(request,
				response);

	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iids = request.getParameter("iid");
		String isBooleans = request.getParameter("isBoolean");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int isBoolean = Integer.parseInt(isBooleans);
		int iid = Integer.parseInt(iids);
		Information information = informationService.getInformationById(iid);
		Reply reply = new Reply(content, isBoolean,new Date(), name, phone, email, information);
		replyService.add(reply);
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(
				request, response);
	}

}
