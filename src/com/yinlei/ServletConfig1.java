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
 * Servlet implementation class ServletConfig1 ��ʾ��λ�ȡServletConfig���� ��ȡ�ķ�ʽ�����֣�
 * 1:���ô�������init����
 * <p>
 * 2:����servletʵ��ȥ�� this.getServletConfig(); ��Ҫ��дinit�Ĵ������ķ�����Ҳ�����ֶ�����
 * </p>
 * <p>
 * ���þ��ǻ�ȡservlet���������
 * </p>
 * 
 */
@WebServlet("/ServletConfig1")
public class ServletConfig1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// д����һ�仰���Ϳ����ˣ�����ڵ������������ʱ��Ҳ��ȥ���ø����init������Ȼ��ͻ�ȥ�ڲ�����init�����У�ȥ��ȡconfig�Ķ���
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

		// ���Ҫȥ������ȡ��ȡ�����ʱ�������д��init�Ĵ������ķ�������ô�Ͳ���ȥ���ø���ģ���ʱ��ȡ�ĵ���null
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