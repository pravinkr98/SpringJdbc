package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.dto.DepartmentDTO;
import com.ps.service.DepartmentMgmtService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		DepartmentMgmtService service=null;
		DepartmentDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get service class object
		service=ctx.getBean("deptService", DepartmentMgmtService.class);
		//set dto value
		dto=new DepartmentDTO();
		dto.setDeptno(32);
		dto.setDname("IT");
		dto.setLoc("hyd");
		try {
			//invoke method
			System.out.println(service.registerDepartment(dto));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}
}//class