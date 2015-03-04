package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.UserService;
import cn.e21.hbjyhf.service.impl.Factory;

public class AreaAction extends BaseAction{
	private AreaService areaService;
	
	public AreaService getAreaService() {
		return areaService;
	}
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Area> areas=areaService.getCitys();
		request.setAttribute("areas",areas );
		request.setAttribute("pid",0 );
		request.getRequestDispatcher("/area/index.jsp").forward(request, response);
	}
	
	public void getCollege(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Area> areas=areaService.getColleges();
		request.setAttribute("areas",areas );
		request.setAttribute("pid",0 );
		request.setAttribute("flag",1 );
		request.getRequestDispatcher("/area/index.jsp").forward(request, response);
	}
	public void getChildren(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pids=request.getParameter("pid");
		int pid=0;
		if(pids!=null&&!pids.equals("")){
			pid=Integer.parseInt(pids);
		}
		List<Area> areas=areaService.getCountryByPid(pid);
		request.setAttribute("areas",areas );
		request.setAttribute("pid",pid );
		request.getRequestDispatcher("/area/index.jsp").forward(request, response);
	}
	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		request.setAttribute("pid",pid );
		request.setAttribute("state",request.getParameter("state"));
		 request.getRequestDispatcher("/area/add_input.jsp").forward( request, response);
	}


	public void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pids=request.getParameter("pid");
		String state=request.getParameter("state");
		System.out.println("*********************");
		System.out.println(state);
		int pid=0;
		if(pids!=null&&!pids.equals("")){
			pid=Integer.parseInt(pids);
		}
		if(pid==0){
			Area parent=areaService.getAreaById(pid);
			Area area=null;
			if("3".equals(state)){
				area=new Area(parent,name,3);
			}else{
				area=new Area(parent,name,1);
			}
		
			areaService.addArea(area);
		}else{
			Area parent=areaService.getAreaById(pid);
			Area area=new Area(parent,name,2);
			areaService.addArea(area);
		}
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(request, response);
	}
	public void updateInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String aids=request.getParameter("aid");
		int pid=0;
		if(aids!=null&&!aids.equals("")){
			pid=Integer.parseInt(aids);
		}
		request.setAttribute("area", areaService.getAreaById(pid));
		 request.getRequestDispatcher("/area/update_input.jsp").forward( request, response);
	}
	public void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String aidS= request.getParameter("aid");
		int aid=0;
		try {
			aid=Integer.parseInt(aidS);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Area area=areaService.getAreaById(aid);
		area.setName(name);
		areaService.updateArea(area);
		request.getRequestDispatcher("/common/pub_update_success.jsp").forward(request, response);
	}
	public void del(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String aids=request.getParameter("aid");
		int aid=Integer.parseInt(aids);
		areaService.delArea(areaService.getAreaById(aid));
		 request.getRequestDispatcher("/common/pub_del_success.jsp").forward( request, response);
	}
}
