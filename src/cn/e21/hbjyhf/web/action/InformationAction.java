package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.Copy;
import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.CompCategoryService;
import cn.e21.hbjyhf.service.CopyService;
import cn.e21.hbjyhf.service.DiplomaService;
import cn.e21.hbjyhf.service.InformationService;
import cn.e21.hbjyhf.service.ReplyService;
import cn.e21.hbjyhf.service.SourceService;
import cn.e21.hbjyhf.service.UserService;
import cn.e21.hbjyhf.web.utils.SendMail;

public class InformationAction extends BaseAction {
	private InformationService informationService;
	private AreaService areaService;
	private SourceService sourceService;
	private DiplomaService diplomaService;
	private CompCategoryService compCategoryService;
	private ReplyService replyService;
	private UserService userService;
	private CopyService copyService;
	public CopyService getCopyService() {
		return copyService;
	}

	public void setCopyService(CopyService copyService) {
		this.copyService = copyService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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

	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/information/index.jsp").forward(request,
				response);
	}


	public void addInput(HttpServletRequest request,// 省级编辑投诉
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.getRequestDispatcher("/information/add_input.jsp").forward(
				request, response);
	}

	public void add(HttpServletRequest request,// 添加投诉
			HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("selectArea");
		String collegeaidS = request.getParameter("collegeaid");
		String aidS = request.getParameter("aid");
		String caidS = request.getParameter("caid");
		
		String didS = request.getParameter("did");
		String cidS = request.getParameter("cid");
		String encode = request.getParameter("encode");
		String sidS = request.getParameter("sid");
		String limit_timeS = request.getParameter("limit_time");
		String label = request.getParameter("label");
		int aid = 0;
		int collegeaid = 0;
		int caid = 0;
		int sid = 0;
		int cid = 0;
		int did = 0;
		Date limit_time=null ;
		Area area1=null;
		Area area2=null;
		Area area3=null;
		try {
			
			if(aidS!=null&&!"".equals(aidS.trim()))
			aid = Integer.parseInt(aidS.trim());
			if(collegeaidS!=null&&!"".equals(collegeaidS.trim()))
			collegeaid = Integer.parseInt(collegeaidS);
			if(caidS!=null&&!"".equals(caidS.trim()))
			caid = Integer.parseInt(caidS);
			if(cidS!=null&&!"".equals(cidS.trim()))
			cid = Integer.parseInt(cidS);
			if(sidS!=null&&!"".equals(sidS.trim()))
			sid = Integer.parseInt(sidS);
			if(didS!=null&&!"".equals(didS.trim()))
				did = Integer.parseInt(didS.trim());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ifrom = request.getParameter("ifrom");
		String department = request.getParameter("department");
		String content = request.getParameter("content");
		String remarks = request.getParameter("remarks");
		String replyphone = request.getParameter("replyphone");
		String replyemail = request.getParameter("replyemail");
		String operater = request.getParameter("operater");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(limit_timeS!=null&&!"".equals(limit_timeS.trim()))
			limit_time=dateFormat.parse(limit_timeS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(aid!=0){
			area1=areaService.getAreaById(aid);
		}
		if(caid!=0){
			
			area2=areaService.getAreaById(caid);
		}
		if(collegeaid!=0){
			area3=areaService.getAreaById(collegeaid);
		}	
			Information information=null;
			if(flag!=null&&"0".equals(flag.trim()) ){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area1,null, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
				
			}else if(flag!=null&&"1".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						null,area2, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"2".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area1,area2, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"3".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area3,null, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}
			
			if(label!=null&&label.equals("submit")){//提交	
			informationService.addInformation(information);
			sendE_mail(aid, collegeaid, caid,flag,request,information);
		
		}
		if(label!=null&&label.equals("save")){//保存
			Copy copy=new Copy(information.getCid(), information.getAid(), information.getCaid(),
					information.getSid(),information.getDid(), encode, content, ifrom, remarks, new Date(), limit_time, operater, replyphone, department, replyemail)
			;
			copyService.add(copy);
		}
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(
				request, response);
	}

	private void sendE_mail(int aid, int collegeaid, int caid,String flag, HttpServletRequest request, Information information) {
		Area area1;
		Area area2;
		Area area3;
		
		boolean flagCity=false;
		boolean flagCountry=false;
		boolean flagCollege=false;
		if(flag!=null&&"0".equals(flag.trim()) ){
			if(aid!=0){
				area1=areaService.getAreaById(aid);
				User user= userService.findUserByAid(area1.getAid());
				if(user!=null){
					String mail=user.getEmail();
					if(mail!=null){
						flagCity=SendMail.send_163(mail,this.getServletContext(),information);
						if(flagCity==true){
							request.setAttribute("messageCity", "发送到市的邮件成功");
						}else{
							request.setAttribute("messageCity", "发送到市的邮件失败，邮件系统问题");
						}
					}else{
						request.setAttribute("messageCity", "发送到市的邮件失败,因为用户邮箱不存在");
					}
				}else{
					request.setAttribute("messageCity", "发送到市的邮件失败，因为用户不存在");
				}
			}
		}else if(flag!=null&&"1".equals(flag.trim())){
			
			if(caid!=0){
				
				area2=areaService.getAreaById(caid);
				User user= userService.findUserByAid(area2.getAid());
				if(user!=null){
					String mail=user.getEmail();
					if(mail!=null){
						flagCountry=SendMail.send_163(mail,this.getServletContext(),information);
						if(flagCountry==true){
							request.setAttribute("messageCountry", "发送到县的邮件成功");
						}else{
							request.setAttribute("messageCountry", "发送到县的邮件失败，邮件系统问题");
						}
					}else{
						request.setAttribute("messageCountry", "发送到县的邮件失败,因为用户邮箱不存在");
					}
				}else{
					request.setAttribute("messageCountry", "发送到县的邮件失败，因为用户不存在");
				}
			}
		}else if(flag!=null&&"2".equals(flag.trim())){
			if(aid!=0){
				area1=areaService.getAreaById(aid);
				User user= userService.findUserByAid(area1.getAid());
				if(user!=null){
					String mail=user.getEmail();
					if(mail!=null){
						flagCity=SendMail.send_163(mail,this.getServletContext(),information);
						if(flagCity==true){
							request.setAttribute("messageCity", "发送到市的邮件成功");
						}else{
							request.setAttribute("messageCity", "发送到市的邮件失败，邮件系统问题");
						}
					}else{
						request.setAttribute("messageCity", "发送到市的邮件失败,因为用户邮箱不存在");
					}
				}else{
					request.setAttribute("messageCity", "发送到市的邮件失败，因为用户不存在");
				}
			}
			if(caid!=0){
				
				area2=areaService.getAreaById(caid);
				User user= userService.findUserByAid(area2.getAid());
				if(user!=null){
					String mail=user.getEmail();
					if(mail!=null){
						flagCountry=SendMail.send_163(mail,this.getServletContext(),information);
						if(flagCountry==true){
							request.setAttribute("messageCountry", "发送到县的邮件成功");
						}else{
							request.setAttribute("messageCountry", "发送到县的邮件失败，邮件系统问题");
						}
					}else{
						request.setAttribute("messageCountry", "发送到县的邮件失败,因为用户邮箱不存在");
					}
				}else{
					request.setAttribute("messageCountry", "发送到县的邮件失败，因为用户不存在");
				}
			}
		}else if(flag!=null&&"3".equals(flag.trim())){
			if(collegeaid!=0){
				area3=areaService.getAreaById(collegeaid);
				User user= userService.findUserByAid(area3.getAid());
				if(user!=null){
					String mail=user.getEmail();
					if(mail!=null){
						flagCollege=SendMail.send_163(mail,this.getServletContext(),information);
						if(flagCollege==true){
							request.setAttribute("messageCollege", "发送到高校的邮件成功");
						}else{
							request.setAttribute("messageCollege", "发送到高校的邮件失败，邮件系统问题");
						}
					}else{
						request.setAttribute("messageCollege", "发送到高校的邮件失败,因为用户邮箱不存在");
					}
				}else{
					request.setAttribute("messageCollege", "发送到高校的邮件失败，因为用户不存在");
				}
			}
		}
		
		
		
		
	}

	


	public void getInformation(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String iids = request.getParameter("iid");
		int iid = Integer.parseInt(iids);
		Information information = informationService.getInformationById(iid);
		request.setAttribute("information", information);
		request.getRequestDispatcher("/reply/noreplyinfor.jsp").forward(
				request, response);
	}
	

	
	public void getCountry(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		String pids = request.getParameter("pid");
		int pid = Integer.parseInt(pids);
		List<Area> countrys=areaService.getCountryByPid(pid);
		StringBuffer buffer=new StringBuffer("<country>");
		for(int i=0;i<countrys.size();i++){
			buffer.append("<mess><id>");
			Area area=countrys.get(i);
			buffer.append(area.getAid()).
			append("</id><name>").append(area.getName()).
			append("</name></mess>");
		}
		buffer.append("</country>");
		response.getWriter().print(buffer.toString());
	}
	
	
	public void sendMail(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String aidS=request.getParameter("aid");
		String iidS=request.getParameter("iid");
		int aid=0;
		int iid=0;
		if(aidS!=null&&!"".equals(aidS)){
			aid=Integer.parseInt(aidS);
		}
		if(iidS!=null&&!"".equals(iidS)){
			iid=Integer.parseInt(iidS);
		}
		if(aid!=0){
			User user= userService.findUserByAid(aid);
			if(user!=null){
				String mail=user.getEmail();
				if(mail!=null&&!"".equals(mail)){
					 Area area=areaService.getAreaById(aid);
					 boolean flag=SendMail.send_163(mail,this.getServletContext(),informationService.getInformationById(iid));
					 if(flag){
						 request.setAttribute("message", "发送成功");
					 }else{
						 request.setAttribute("message", "发送失败，因为邮件系统问题");
					 }
					 
				}else{
					request.setAttribute("message", "发送失败，因为邮箱未完善");
				}
			}else{
				request.setAttribute("message", "发送失败，因为用户不存在");
			}
		}
		request.getRequestDispatcher("/common/pub_send_success.jsp").forward(
				request, response);
	}
	
	
	public void getCopy(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		Copy copy=copyService.getCopyById(id);
		request.setAttribute("copy", copy);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.getRequestDispatcher("/information/copy_add_input.jsp").forward(
				request, response);
	}
	public void getCopys(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Copys", copyService.getCopys());
		request.getRequestDispatcher("/information/copy_list.jsp").forward(
				request, response);
	}
	public void copyUpdate(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String didS = request.getParameter("did");
		String flag = request.getParameter("selectArea");
		String collegeaidS = request.getParameter("collegeaid");
		String aidS = request.getParameter("aid");
		String caidS = request.getParameter("caid");
		String cidS = request.getParameter("cid");
		String encode = request.getParameter("encode");
		String sidS = request.getParameter("sid");
		String limit_timeS = request.getParameter("limit_time");
		String id = request.getParameter("id");
		int did = 0;
		int aid = 0;
		int collegeaid = 0;
		int caid = 0;
		int sid = 0;
		int cid = 0;
		Date limit_time=null ;
		Area area1=null;
		Area area2=null;
		Area area3=null;
		try {
			if(didS!=null&&!"".equals(didS.trim()))
			did = Integer.parseInt(didS.trim());
			if(aidS!=null&&!"".equals(aidS.trim()))
			aid = Integer.parseInt(aidS.trim());
			if(collegeaidS!=null&&!"".equals(collegeaidS.trim()))
			collegeaid = Integer.parseInt(collegeaidS);
			if(caidS!=null&&!"".equals(caidS.trim()))
			caid = Integer.parseInt(caidS);
			if(cidS!=null&&!"".equals(cidS.trim()))
			cid = Integer.parseInt(cidS);
			if(sidS!=null&&!"".equals(sidS.trim()))
			sid = Integer.parseInt(sidS);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ifrom = request.getParameter("ifrom");
		String department = request.getParameter("department");
		String content = request.getParameter("content");
		String remarks = request.getParameter("remarks");
		String replyphone = request.getParameter("replyphone");
		String replyemail = request.getParameter("replyemail");
		String operater = request.getParameter("operater");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(limit_timeS!=null&&!"".equals(limit_timeS.trim()))
			limit_time=dateFormat.parse(limit_timeS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(aid!=0){
			area1=areaService.getAreaById(aid);
		}
		if(caid!=0){
			
			area2=areaService.getAreaById(caid);
		}
		if(collegeaid!=0){
			area3=areaService.getAreaById(collegeaid);
		}
			
			Information information=null;
			if(flag!=null&&"0".equals(flag.trim()) ){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area1,null, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"1".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						null,area2, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"2".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area1,area2, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"3".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area3,null, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}
			Copy copy=new Copy(Integer.parseInt(id),information.getCid(), information.getAid(), information.getCaid(),
					information.getSid(),information.getDid(), encode, content, ifrom, remarks, 
					new Date(), limit_time, operater, replyphone, department, replyemail);
			copyService.update(copy);
		request.getRequestDispatcher("/common/pub_update_success.jsp").forward(
				request, response);
	}
	public void copyUpdateInput(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		Copy copy=copyService.getCopyById(id);
		request.setAttribute("copy", copy);
		request.setAttribute("ccList", compCategoryService.getAllComCategory());
		request.setAttribute("diplomaList", diplomaService.getAllDiploma());
		request.setAttribute("sourceList", sourceService.getAllSource());
		request.setAttribute("citys", areaService.getCitys());
		request.setAttribute("colleges", areaService.getColleges());
		request.getRequestDispatcher("/information/copy_add_input.jsp").forward(
				request, response);
	}
	public void copyDel(HttpServletRequest request,// 调到未回复详细页面
			HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		Copy copy=copyService.getCopyById(id);
		copyService.del(copy);
		request.getRequestDispatcher("/common/pub_del_success.jsp").forward(
				request, response);
	}
	public void submit(HttpServletRequest request,// 提交投诉
			HttpServletResponse response) throws ServletException, IOException {
		String didS = request.getParameter("did");
		String flag = request.getParameter("selectArea");
		String collegeaidS = request.getParameter("collegeaid");
		String aidS = request.getParameter("aid");
		String caidS = request.getParameter("caid");
		String cidS = request.getParameter("cid");
		String encode = request.getParameter("encode");
		String sidS = request.getParameter("sid");
		String limit_timeS = request.getParameter("limit_time");
		String id = request.getParameter("id");
		int did = 0;
		int aid = 0;
		int collegeaid = 0;
		int caid = 0;
		int sid = 0;
		int cid = 0;
		Date limit_time=null ;
		Area area1=null;
		Area area2=null;
		Area area3=null;
		try {
			if(didS!=null&&!"".equals(didS.trim()))
			did = Integer.parseInt(didS.trim());
			if(aidS!=null&&!"".equals(aidS.trim()))
			aid = Integer.parseInt(aidS.trim());
			if(collegeaidS!=null&&!"".equals(collegeaidS.trim()))
			collegeaid = Integer.parseInt(collegeaidS);
			if(caidS!=null&&!"".equals(caidS.trim()))
			caid = Integer.parseInt(caidS);
			if(cidS!=null&&!"".equals(cidS.trim()))
			cid = Integer.parseInt(cidS);
			if(sidS!=null&&!"".equals(sidS.trim()))
			sid = Integer.parseInt(sidS);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ifrom = request.getParameter("ifrom");
		String department = request.getParameter("department");
		String content = request.getParameter("content");
		String remarks = request.getParameter("remarks");
		String replyphone = request.getParameter("replyphone");
		String replyemail = request.getParameter("replyemail");
		String operater = request.getParameter("operater");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(limit_timeS!=null&&!"".equals(limit_timeS.trim()))
			limit_time=dateFormat.parse(limit_timeS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(aid!=0){
			area1=areaService.getAreaById(aid);
		}
		if(caid!=0){
			
			area2=areaService.getAreaById(caid);
		}
		if(collegeaid!=0){
			area3=areaService.getAreaById(collegeaid);
		}	
			
			Information information=null;
			if(flag!=null&&"0".equals(flag.trim()) ){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area1,null, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"1".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						null,area2, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"2".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area1,area2, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}else if(flag!=null&&"3".equals(flag.trim())){
				information = new Information(compCategoryService.getComCategoryById(cid),
						area3,null, sourceService.getSourceById(sid),diplomaService.getDiplomById(did),
						encode,content, ifrom, remarks, new Date(), limit_time, operater, replyphone,department,replyemail);
			}
			informationService.addInformation(information);
			sendE_mail(aid, collegeaid, caid,flag,request,information);
		
			copyService.del(copyService.getCopyById(Integer.parseInt(id)));
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(
				request, response);
	}
}
