package com.yj.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class HttpServletProxy
 */
public class HttpServletProxy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginServlet.class);
       
	private String targetServlet;////��ǰ�ͻ��������Servlet����
    private HttpServlet proxyServlet;//����servlet
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpServletProxy() {
        super();
        logger.debug("HttpServletProxy-->HttpServletProxy()");
    }
    
    public void init() throws ServletException {
    	logger.debug("HttpServletProxy-->init()");
        this.targetServlet = getInitParameter("targetServlet");//���web.xml�ж����servlet������
        getServletBean();//������servlet��ʼ����Ŀ��servlet
        proxyServlet.init(getServletConfig());//ʵ���������õ���Ŀ��servlet��init����
    }
    
    private void getServletBean() {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());  
        this.proxyServlet = (HttpServlet) wac.getBean(targetServlet);  
    }

    @Override  
    public void service(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException, RuntimeException {
    	logger.debug("HttpServletProxy-->service(HttpServletRequest,HttpServletResponse)");
        proxyServlet.service(request, response);//��service�����е���Ŀ��servlet��service������servlet����ݿͻ�������ȥ������Ӧ�����󷽷���Get/Post��  
    }

	public void destroy() {  
        super.destroy();
        logger.debug("HttpServletProxy-->destroy()");
    }
}
