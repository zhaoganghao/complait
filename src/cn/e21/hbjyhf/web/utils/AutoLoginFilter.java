package cn.e21.hbjyhf.web.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.UserService;
import cn.e21.hbjyhf.service.impl.UserServiceImpl;


public class AutoLoginFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		if(request.getSession().getAttribute("user")!=null){
			chain.doFilter(request, response);
			return;
		}
		
		
		String value = null;
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null && i<cookies.length;i++){
			if(cookies[i].getName().equals("autologin")){
				value = cookies[i].getValue();
			}
		}
		
		if(value!=null){
			String username = value.split("\\.")[0];
			String password = value.split("\\.")[1];
			UserService userService=new UserServiceImpl();
			User user=userService.findUser(username);
			String dbpassword = user.getPassword();
			if(password.equals(dbpassword)){
				request.getSession().setAttribute("user", user);
			}
		}
		
		chain.doFilter(request, response);
		

	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
