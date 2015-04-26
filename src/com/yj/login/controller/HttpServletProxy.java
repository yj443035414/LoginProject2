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
       
	private String targetServlet;////当前客户端请求的Servlet名字
    private HttpServlet proxyServlet;//代理servlet
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpServletProxy() {
        super();
        logger.debug("HttpServletProxy-->HttpServletProxy()");
    }
    
    public void init() throws ServletException {
    	logger.debug("HttpServletProxy-->init()");
        this.targetServlet = getInitParameter("targetServlet");//获得web.xml中定义的servlet的名字
        getServletBean();//将代理servlet初始化成目标servlet
        proxyServlet.init(getServletConfig());//实际真正调用的是目标servlet的init方法
    }
    
    private void getServletBean() {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());  
        this.proxyServlet = (HttpServlet) wac.getBean(targetServlet);  
    }

    @Override  
    public void service(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException, RuntimeException {
    	logger.debug("HttpServletProxy-->service(HttpServletRequest,HttpServletResponse)");
        proxyServlet.service(request, response);//在service方法中调用目标servlet的service方法，servlet会根据客户的请求去调用相应的请求方法（Get/Post）  
    }

	public void destroy() {  
        super.destroy();
        logger.debug("HttpServletProxy-->destroy()");
    }
}
