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
 * 
 *                    <p>
 *                    当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
 *                    会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，
 *                    将ServletConfig对象传递给servlet。进而，
 *                    程序员通过ServletConfig对象就可以得到当前servlet的初始化参数信息。
 *                    </p>
 *                    <p>
 *                    在开发中ServletConfig的作用有如下三个：
 *                    <p>
 *                    1）获得字符集编码 String charset =
 *                    this.config.getInitParameter("charset");
 *                    </P>
 *                    <p>
 *                    2）获得数据库连接信息 String url =
 *                    this.config.getInitParameter("url"); String username =
 *                    this.config.getInitParameter("username"); String password
 *                    = this.config.getInitParameter("password");
 *                    </P>
 *                    <P>
 *                    3）获得配置文件 String configFile =
 *                    this.config.getInitParameter("config");
 *                    </p>
 *                    </P>
 */
@WebServlet(urlPatterns = { "/ServletConfig2" }, initParams = { @WebInitParam(name = "username", value = "tom"),
		@WebInitParam(name = "age", value = "20") })
public class ServletConfig2 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 拿取配置的单个信息
		ServletConfig config = this.getServletConfig();
		// System.out.println("username:" +
		// config.getInitParameter("username"));
		// System.out.println("age:" + config.getInitParameter("age"));

		// 拿取配置的多个信息
		Enumeration<String> enu = config.getInitParameterNames();
		
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			System.out.println(name + " : " + config.getInitParameter(name));
		}
		
		System.out.println("你想咋地");
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
