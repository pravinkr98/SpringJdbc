package com.ps.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginAuthenticationDAOImpl implements LoginAuthenticationDAO {
	
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String validateUser(String username, String password) {
		Map<String, Object> outParams=null;
		String result=null;
		//set Procedure name to SimpleJdbcCall
		sjc.setProcedureName("P_AUTH");
		//execute SimpleJdbcCall and PL/SQL procedure
		outParams=sjc.execute(username,password);
		//get outParams value from map object
		result=(String) outParams.get("RESULT");
		return result;
	}

}
