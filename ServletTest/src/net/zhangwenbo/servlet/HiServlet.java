/**
 * �Լ�д��servletͨ��ʵ��sevlet�ӿ� ��ʵ 
 */
package net.zhangwenbo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Iver3oN Zhang
 * @date 2016��3��11��
 * @email grepzwb@qq.com
 * HiServlet.java
 * Impossible is nothing
 */
public class HiServlet implements Servlet {

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 * / �ú������ڳ�ʼ����servlet�� ���������ǵ���Ĺ��캯��
	// �ú���ֻ�ǻᱻ����һ�Σ� ���û���һ�η��ʸ�servlet��ʱ�򱻵���
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init servlet..");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletConfig()
	 * // ���ڵõ�servlet�����ļ� �����������޹�
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 * // service �������ڴ���ҵ���߼�
	// ����ԱӦ����ҵ���߼�����д������
	// �ú������û�ÿ�η���servlet��ʱ�򶼻ᱻ����
	// ServletRequest �������ڻ�ÿͻ�����Ϣ��ServletResponse ����������ͻ��˷�����Ϣ���ͻ��˿������Ϊ�������
	// servelt jsp b/s
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service it..");
		PrintWriter pw = res.getWriter();
		pw.println("hello world");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "zwb ��servlet";
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#destroy()
	 * // ����servletʵ�����ͷ��ڴ棩
	// 1 reload ��servlet(webApp)
	// 2 �ر�Tomcat ����˵ �ػ�֮�� ��������������
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory it.");
	}

}
