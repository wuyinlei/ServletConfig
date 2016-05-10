package com.yinlei;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfig1 演示如何获取ServletConfig对象 获取的方式有两种：
 * 1:采用带参数的init方法
 * <p>
 * 2:采用servlet实例去拿 this.getServletConfig(); 不要重写init的带参数的方法，也可以手动调用
 * </p>
 * <p>
 * 作用就是获取servlet的相关配置
 * </p>
 * 
 */
@WebServlet("/ServletConfig1")
public class ServletConfig1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 写上这一句话，就可以了，这个在调用这个方法的时候，也会去调用父类的init方法，然后就会去在参数的init方法中，去获取config的对象
		super.init(config);
		this.config = config;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// org.apache.catalina.core.StandardWrapperFacade@3e47172d
		// System.out.println(config);

		// 这个要去父类中取获取，这个时候如果重写了init的带参数的方法，那么就不会去调用父类的，此时获取的到是null
		ServletConfig config1 = this.getServletConfig();
		System.out.println(config == config1);
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
