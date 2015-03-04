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
import cn.e21.hbjyhf.web.utils.MD5;

public class UserAction extends BaseAction{
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum=request.getParameter("pagenum");
		String servletName=this.getServletName();
		Page page=userService.getUserPage(pagenum, request.getContextPath()+"/"+"Servlet/"+servletName);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/user/index.jsp").forward(request, response);
	}
	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AreaService areaService=Factory.getAreaService();
		List<Area> areas=areaService.getAreas();
		List<Area> ins=userService.getArea();
		for(Area o:ins){
			areas.remove(o);
		}
		request.setAttribute("areas",areas );
		 request.getRequestDispatcher("/user/register_input.jsp").forward( request, response);
	}

	

	public void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String aidS= request.getParameter("aid");
		String address= request.getParameter("address");
		int aid=0;
		try {
			aid=Integer.parseInt(aidS);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user=new User(username, MD5.Md5(password), name, phone, email, address,Factory.getAreaService().getAreaById(aid));
		try {
			userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "用户名以用了");
			request.getRequestDispatcher("/common/exception.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/common/pub_add_success.jsp").forward(request, response);
	}
	public void updateInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AreaService areaService=Factory.getAreaService();
		String username=request.getParameter("username");
		User user=userService.findUser(username);
		request.setAttribute("area", areaService.getAllArea());
		request.setAttribute("user2", user);
		 request.getRequestDispatcher("/user/update_input.jsp").forward( request, response);
	}
	
	public void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String aidS= request.getParameter("aid");
		String address= request.getParameter("address");
		int aid=0;
		try {
			aid=Integer.parseInt(aidS);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user=userService.findUser(username);
		User user2=null;
		if(user.getPassword().equals(password)){
			user2=new User(user.getUsername(),password, name, phone, email,address, user.getAid());
		}else{
			user2=new User(user.getUsername(),MD5.Md5(password), name, phone, email,address, user.getAid());
		}
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "用户名以用了");
			request.getRequestDispatcher("/common/exception.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/common/pub_update_success.jsp").forward(request, response);
	}
	public void updateBySelf(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user =(User) request.getSession().getAttribute("user");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String aidS= request.getParameter("aid");
		String address= request.getParameter("address");
		User user2=null;
		if(user.getPassword().equals(password)){
			user2=new User(user.getUsername(),password, name, phone, email,address, user.getAid());
		}else{
			user2=new User(user.getUsername(),MD5.Md5(password), name, phone, email,address, user.getAid());
		}
		
		try {
			userService.updateUser(user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "用户名以用了");
			request.getRequestDispatcher("/common/exception.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user2);
		request.getRequestDispatcher("/common/pub_update_success.jsp").forward(request, response);
	}
	public void del(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		userService.delUser(userService.findUser(username));
		 request.getRequestDispatcher("/common/pub_del_success.jsp").forward( request, response);
	}
	public void getAllUsers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("users", userService.getAllUser());
		 request.getRequestDispatcher("/user/list_all.jsp").forward( request, response);
	}
	public void checkUserName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		System.out.println(username);
		User user=userService.findUser(username);
		System.out.println(user);
		if(user!=null){
			response.getWriter().print("用户名已存在");
		}
	}
}
