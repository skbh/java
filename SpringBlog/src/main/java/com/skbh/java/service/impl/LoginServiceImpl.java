package com.skbh.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.skbh.java.manager.LoginManager;
import com.skbh.java.model.LoginDetails;
import com.skbh.java.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginManager loginManager;

	public LoginManager getLoginManager() {
		return loginManager;
	}

	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

	@Override
	public boolean registerUserService(LoginDetails logindetails) {
		return loginManager.registerUser(logindetails);

	}

}
