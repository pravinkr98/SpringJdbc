package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.service.LoginAuthenticationMgmtService;

public class LoginAuthenticationTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoginAuthenticationMgmtService service=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get service class bean object
		service=ctx.getBean("loginService", LoginAuthenticationMgmtService.class);
		//invoke method
		try {
			System.out.println(service.signIn("karan", "hyd"));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//method

}//class
