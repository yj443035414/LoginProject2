package com.yj.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.yj.login.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginServlet.class);
	
	LoginService loginService;
	public void setLoginService(LoginService loginService) {
		logger.debug("LoginServlet-->setLoginService(LoginService)");
		this.loginService = loginService;
	}
	
	@Override
	public void init() throws ServletException {
		logger.debug("LoginServlet-->init()");
	}
    /**
     * 默认构造函数
     */
    public LoginServlet() {
    	logger.debug("LoginServlet-->LoginServlet()");
    }

	@Override
	public void destroy() {
		super.destroy();
		logger.debug("LoginServlet-->destroy()");
	}

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginServlet-->doGet(HttpServletRequest,HttpServletResponse)");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		boolean flag = loginService.checkAccount(userName, password);
		JSONObject result = new JSONObject();
		if(flag){
			try {
				result.put("message", "OK");
				result.put("userName",userName);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(result.toString());
		}else{
			try {
				result.put("message", "NO");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(result.toString());
		}
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
