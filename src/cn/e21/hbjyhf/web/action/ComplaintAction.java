package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.service.CompCategoryService;

public class ComplaintAction extends BaseAction{
	private CompCategoryService compCategoryService;
	public CompCategoryService getCompCategoryService() {
		return compCategoryService;
	}

	public void setCompCategoryService(CompCategoryService compCategoryService) {
		this.compCategoryService = compCategoryService;
	}
	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<CompCategory> categorys=compCategoryService.getAllComCategory();
		request.setAttribute("categorys",categorys );
		request.getRequestDispatcher("/complaint/index.jsp").forward(request, response);
	}
	
	

	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/complaint/add_input.jsp").forward( request, response);
	}


	public void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		CompCategory category=new CompCategory(name);
		compCategoryService.add(category);
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(request, response);
	}
	public void updateInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		CompCategory category=compCategoryService.getComCategoryById(id);
		request.setAttribute("category",category );
		 request.getRequestDispatcher("/complaint/update_input.jsp").forward( request, response);
	}
	public void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		String name=request.getParameter("name");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		CompCategory category=compCategoryService.getComCategoryById(id);
		category.setName(name);
		compCategoryService.update(category);
		request.getRequestDispatcher("/common/pub_update_success.jsp").forward(request, response);
	}
	public void del(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		CompCategory category=compCategoryService.getComCategoryById(id);
		compCategoryService.del(category);
		 request.getRequestDispatcher("/common/pub_del_success.jsp").forward( request, response);
	}
}
