package cn.e21.hbjyhf.web.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.e21.hbjyhf.web.utils.BeanFactory;



public class BaseAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {

		BeanFactory factory = (BeanFactory)getServletContext().getAttribute(InitBeanFactoryServlet.INIT_FACTORY_NAME);

		//利用反射，调用this对象中的相关的setters方法！
		Method[] methods = this.getClass().getMethods();
		for(Method m:methods){
			if(m.getName().startsWith("set")){
				
				//ArticleDao
				String propertyName = m.getName().substring(3);
				
				StringBuffer sb = new StringBuffer(propertyName);
				sb.replace(0, 1, (propertyName.charAt(0)+"").toLowerCase());
				
				//articleDao
				propertyName = sb.toString();
				
				//约定：setters方法所决定的属性（property）名，与配置文件中相应的对象命名一致！
				Object bean = factory.getBean(propertyName);
				
				try {
					//将依赖对象注入客户端
					m.invoke(this, bean);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		//执行父类的职责：根据请求是GET还是POST方法，调用doGet或doPost！
		super.service(arg0, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req,resp);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		//首先获取方法参数
		String method = request.getParameter("method");
		
		//如果客户端不传递method参数，则默认调用execute()方法
		if(method == null || method.trim().equals("")){
			execute(request,response);
		}else{
			//根据method参数的取值，调用相关的方法
			try {
				Method m = this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				
				//将请求转发到相应的方法中
				m.invoke(this, request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		//什么也不做！
	}

}
