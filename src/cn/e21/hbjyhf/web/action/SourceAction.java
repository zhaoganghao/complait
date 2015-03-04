package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.service.SourceService;

public class SourceAction extends BaseAction{
	private SourceService sourceService;

	public SourceService getSourceService() {
		return sourceService;
	}



	public void setSourceService(SourceService sourceService) {
		this.sourceService = sourceService;
	}


	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Source> categorys=sourceService.getAllSource();
		request.setAttribute("categorys",categorys );
		request.getRequestDispatcher("/source/index.jsp").forward(request, response);
	}
	
	


	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/source/add_input.jsp").forward( request, response);
	}


	public void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		Source category=new Source(name);
		category.setName(name);
		sourceService.add(category);
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(request, response);
	}
	public void updateInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		Source category=sourceService.getSourceById(id);
		request.setAttribute("category",category );
		 request.getRequestDispatcher("/source/update_input.jsp").forward( request, response);
	}
	public void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		String name=request.getParameter("name");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		Source category=sourceService.getSourceById(id);
		category.setName(name);
		sourceService.update(category);
		request.getRequestDispatcher("/common/pub_update_success.jsp").forward(request, response);
	}
	public void del(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null&&!ids.equals("")){
			id=Integer.parseInt(ids);
		}
		Source category=sourceService.getSourceById(id);
		sourceService.del(category);
		 request.getRequestDispatcher("/common/pub_del_success.jsp").forward( request, response);
	}
}
