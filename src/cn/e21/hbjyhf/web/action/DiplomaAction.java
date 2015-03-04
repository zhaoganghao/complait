package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.model.Diploma;
import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.service.DiplomaService;

public class DiplomaAction extends BaseAction{
	private DiplomaService diplomaService;
	
	public DiplomaService getDiplomaService() {
		return diplomaService;
	}



	public void setDiplomaService(DiplomaService diplomaService) {
		this.diplomaService = diplomaService;
	}



	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Diploma> categorys=diplomaService.getAllDiploma();
		request.setAttribute("categorys",categorys );
		request.getRequestDispatcher("/diploma/index.jsp").forward(request, response);
	}
	
	

	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/diploma/add_input.jsp").forward( request, response);
	}


	public void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		Diploma category=new Diploma(name);
		category.setName(name);
		diplomaService.add(category);
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(request, response);
	}
	public void updateInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		Diploma category=diplomaService.getDiplomById(id);
		request.setAttribute("category",category );
		 request.getRequestDispatcher("/diploma/update_input.jsp").forward( request, response);
	}
	public void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		String name=request.getParameter("name");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		Diploma category=diplomaService.getDiplomById(id);
		category.setName(name);
		diplomaService.update(category);
		request.getRequestDispatcher("/common/pub_update_success.jsp").forward(request, response);
	}
	public void del(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		Diploma category=diplomaService.getDiplomById(id);
		diplomaService.del(category);
		 request.getRequestDispatcher("/common/pub_del_success.jsp").forward( request, response);
	}
}
