package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.dto.StudentDTO;
import com.ps.service.StudentManagementService;
import static java.lang.System.*;

public class CallbackInterfaceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentManagementService service=null;
		StudentDTO dto=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get bean 
		service=ctx.getBean("studService", StudentManagementService.class);
		//use service and invoke method
		dto=service.fetchStudentRecordByNo(27);
		if(dto!=null) {
			out.println("--------------------------Student Details-----------------------");
			out.println("SNO   NAME    ADDRS       AVG     TOTAL    RESULT  ");
			out.println("---------------------------------------------------------------------");
			out.println(dto.getSno()+"   "+dto.getName()+"   "+dto.getAddrs()+"   "+dto.getAvg()+"   "+dto.getTotal()+"   "+dto.getResult());
		}
		else
			out.print("Record not found.");
		
	}//main

}//class
