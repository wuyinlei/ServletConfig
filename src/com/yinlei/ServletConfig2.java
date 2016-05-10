package com.yinlei;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfig2
 * <p>
 * 演示servletconfig配置信息
 * </p>
 * <p>
 * 在这里我们可以配置多个initParam配置信息，initParams = { @WebInitParam(name = "username",
 * value = "tom"),
 * 
 * @WebInitParam(name = "age", value = "20") }
 *                    </p>
 */
@WebServlet(urlPatterns = { "/ServletConfig2" }, initParams = { @WebInitParam(name = "username", value = "tom"),
		@WebInitParam(name = "age", value = "20") })
public class ServletConfig2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//拿取配置的单个信息
		ServletConfig config = this.getServletConfig();
		//System.out.println("username:" + config.getInitParameter("username"));
		//System.out.println("age:" + config.getInitParameter("age"));
		
		//拿取配置的多个信息
		Enumeration<String> enu = config.getInitParameterNames();
		while(enu.hasMoreElements()){
			String name = enu.nextElement();
			System.out.println(name + " : " + config.getInitParameter(name));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
