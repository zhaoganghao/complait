package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.Forward;
import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.Reply;
import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.CountryReplyService;
import cn.e21.hbjyhf.service.ForwardService;
import cn.e21.hbjyhf.service.InformationService;
import cn.e21.hbjyhf.service.ReplyService;
import cn.e21.hbjyhf.service.UserService;
import cn.e21.hbjyhf.web.utils.SendMail;

public class ReplyAction extends BaseAction {
	private ReplyService replyService;
	private InformationService informationService;
	private AreaService areaService;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public AreaService getAreaService() {
		return areaService;
	}
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	public ForwardService getForwardService() {
		return forwardService;
	}
	public void setForwardService(ForwardService forwardService) {
		this.forwardService = forwardService;
	}
	private CountryReplyService countryReplyService;
	private ForwardService forwardService;
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
		request.getRequestDispatcher("/Reply/index.jsp").forward(request,
				response);
	}
	//省局查看投诉
	public void execute2(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String pagenum = request.getParameter("pagenum");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Page page =null;
			String wherejpql= "o.aid.aid = "+user.getAid().getAid();
			String servletName = this.getServletName();
			
			page=(Page) informationService.getInformationPage(
					wherejpql.toString(), pagenum, null, request.getContextPath()
							+ "/" + "Servlet/" + servletName);
			request.setAttribute("page", page);
			request.setAttribute("methodname", "execute2");
			request.getRequestDispatcher("/reply/list.jsp").forward(request,
					response);
		}
	public void getInformation(HttpServletRequest request,// 获得详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String iids = request.getParameter("iid");
		int iid = Integer.parseInt(iids);
		Information information = informationService.getInformationById(iid);
		request.setAttribute("information", information);
		request.getRequestDispatcher("/reply/infor.jsp").forward(request,
				response);
	}
	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String iid=request.getParameter("iid");
		 request.setAttribute("iid", iid);
		 request.getRequestDispatcher("/reply/add_input.jsp").forward( request, response);
		
	}
	public void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String iids=request.getParameter("iid");
		
		String isBooleans=request.getParameter("isBoolean");
		String content=request.getParameter("content");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		int isBoolean=Integer.parseInt(isBooleans);
		int iid =Integer.parseInt(iids);
		Reply reply=new Reply(content, isBoolean, new Date(), name, phone, email, informationService.getInformationById(iid));
		replyService.add(reply);
		 request.getRequestDispatcher("/common/pub_add_success.jsp").forward( request, response);
	}
	public void addForwardInput(HttpServletRequest request,//回复省
			HttpServletResponse response) throws ServletException, IOException {
		String iid=request.getParameter("iid");
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("area",user.getAid().getChildren() );
		 request.setAttribute("iid", iid);
		 request.getRequestDispatcher("/reply/forward_input.jsp").forward( request, response);
		
	}
	public void addForward(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String iids=request.getParameter("iid");
		String remarks=request.getParameter("remarks");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String aids=request.getParameter("aid");
		int aid=Integer.parseInt(aids);
		int iid =Integer.parseInt(iids);
		Information information =informationService.getInformationById(iid);
		Area area=areaService.getAreaById(aid);
		Forward f=new Forward(name, remarks, new Date(), email, phone, information ,area);
		forwardService.add(f);
		this.sendMail(request,response,aid, information);
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward( request, response);
	}
	private void sendMail(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response,int aid, Information information)throws ServletException, IOException{
		User user= userService.findUserByAid(aid);
		if(user!=null){
			String mail=user.getEmail();
			if(mail!=null&&!"".equals(mail)){
				 Area area=areaService.getAreaById(aid);
				 boolean flag=SendMail.send_163(mail,this.getServletContext(),information);
				 if(flag){
					 request.setAttribute("message", "邮件发送成功");
				 }else{
					 request.setAttribute("message", "邮件发送失败，因为邮件系统问题");
				 }
				 
			}else{
				request.setAttribute("message", "邮件发送失败，因为邮箱未完善");
			}
		}else{
			request.setAttribute("message", "邮件发送失败，因为用户不存在");
		}
	}
}	
	
