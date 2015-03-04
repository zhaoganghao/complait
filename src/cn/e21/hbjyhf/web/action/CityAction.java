package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CityAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method= request.getParameter("method");
		System.out.println(method);
		if(method!=null&&"\"addInput\"".equals(method)){
			return;
		}
		if(method!=null&&"\"add\"".equals(method)){
			return;
		}
		
	}


}
