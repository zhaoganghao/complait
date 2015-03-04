package cn.e21.hbjyhf.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.UserService;
import cn.e21.hbjyhf.web.utils.MD5;

public class LoginAction extends BaseAction{
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=userService.findUser(username);
		
		if(user==null||!user.getPassword().equals(MD5.Md5(password.trim()))){
			request.setAttribute("message", "用户不存在或密码错误");
			request.getRequestDispatcher("/common/exception.jsp").forward(request, response);
			return;	
		}
		sendAutoLoginCookie(request,response,user);
		HttpSession session= request.getSession();
		session.setAttribute("user", user);
		
		int state=user.getAid().getState();
		if(state==0){
			request.getRequestDispatcher("/information/index.jsp").forward(request, response);
			return;
		}
		if(state==1){
			request.getRequestDispatcher("/reply/index.jsp").forward(request, response);
			return;
		}
		if(state==2){
			request.getRequestDispatcher("/country/index.jsp").forward(request, response);
			return;
		}
		if(state==3){
			request.getRequestDispatcher("/college/index.jsp").forward(request, response);
			return;
		}
	}
private void sendAutoLoginCookie(HttpServletRequest request, HttpServletResponse response, User user) {
		String logintimes=request.getParameter("logintime");
		int logintime=3600;
		if(logintimes!=null){
		 logintime = 3600*24*30;
		}
		Cookie cookie = new Cookie("autologin",user.getUsername() + "." + user.getPassword());
		cookie.setMaxAge(logintime);
		System.out.println(request.getContextPath());
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
	}
	
	
	public void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath()+"/"+"login.jsp");
	}
}
