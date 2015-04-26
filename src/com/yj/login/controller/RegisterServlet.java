package com.yj.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yj.login.service.LoginService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(RegisterServlet.class);
       
	LoginService loginService;
	public void setLoginService(LoginService loginService) {
		logger.debug("RegisterServlet-->setLoginService(LoginService)");
		this.loginService = loginService;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        logger.debug("RegisterServlet-->RegisterServlet()");
    }

    @Override
	public void init() throws ServletException {
		logger.debug("RegisterServlet-->init()");
	}
    
    @Override
	public void destroy() {
		super.destroy();
		logger.debug("RegisterServlet-->destroy()");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("RegisterServlet-->doGet(HttpServletRequest,HttpServletResponse)");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		boolean flag = loginService.checkAccount(userName, password);
		if(flag){
			response.sendRedirect("success.jsp?userName="+userName);
		}else{
			response.sendRedirect("failure.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
