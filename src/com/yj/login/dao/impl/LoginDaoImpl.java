package com.yj.login.dao.impl;

import com.yj.login.dao.LoginDao;

public class LoginDaoImpl implements LoginDao{

	public boolean checkAccount(String userName,String password){
		boolean flag = false;
		if("yangjiang".equals(userName) && "yj".equals(password)){
			flag = true;
		}
		return flag;
	}
}
