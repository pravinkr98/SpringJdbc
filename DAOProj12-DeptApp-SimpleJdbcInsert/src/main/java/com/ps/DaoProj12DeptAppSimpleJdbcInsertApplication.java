package com.ps;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.ps.dto.DepartmentDTO;
import com.ps.service.DepartmentMgmtService;

@SpringBootApplication
public class DaoProj12DeptAppSimpleJdbcInsertApplication {
	
	@Autowired
	private DataSource ds;
	
	@Bean
	public SimpleJdbcInsert createSJI() {
		return new SimpleJdbcInsert(ds);
	}

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		DepartmentMgmtService service=null;
		DepartmentDTO dto=null;
		//create IOC container
		
		ctx=SpringApplication.run(DaoProj12DeptAppSimpleJdbcInsertApplication.class, args);		
		//get service class object
		service=ctx.getBean("deptService", DepartmentMgmtService.class);
		//set dto value
		dto=new DepartmentDTO();
		dto.setDeptno(34);
		dto.setDname("IIT");
		dto.setLoc("delhi");
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

}
