package com.yj.login.service.impl;

import com.yj.login.dao.LoginDao;
import com.yj.login.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public boolean checkAccount(String userName, String password) {
		return loginDao.checkAccount(userName, password);
	}

}
