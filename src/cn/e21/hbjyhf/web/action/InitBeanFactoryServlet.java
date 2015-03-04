package cn.e21.hbjyhf.web.action;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.e21.hbjyhf.web.utils.BeanFactory;
import cn.e21.hbjyhf.web.utils.PropertiesBeanFactory;



public class InitBeanFactoryServlet extends HttpServlet {
	
	public static final String INIT_FACTORY_NAME = "_my_bean_factory";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		BeanFactory factory = null;
		String configLocation = config.getInitParameter("configLocation");
		if(configLocation == null){
			factory = new PropertiesBeanFactory();
		}else{
			factory = new PropertiesBeanFactory(configLocation);
		}
		System.out.println("初始化BeanFactory......");
		getServletContext().setAttribute(INIT_FACTORY_NAME, factory);
	}

}
