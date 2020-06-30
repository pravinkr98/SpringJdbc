package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.LoginAuthenticationDAO;

@Service("loginService")
public class LoginAuthenticationMgmtServiceImpl implements LoginAuthenticationMgmtService {
	
	@Autowired
	private LoginAuthenticationDAO dao;

	@Override
	public String signIn(String username, String password) {
		String result=null;
		//use dao
		result=dao.validateUser(username, password);
		return result;
	}

}
