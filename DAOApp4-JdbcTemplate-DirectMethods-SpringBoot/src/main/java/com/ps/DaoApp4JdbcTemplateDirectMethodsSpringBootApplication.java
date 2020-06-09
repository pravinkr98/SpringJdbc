package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.service.EmployeeService;

@SpringBootApplication
public class DaoApp4JdbcTemplateDirectMethodsSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
				
		//create IOC container
		ctx=SpringApplication.run(DaoApp4JdbcTemplateDirectMethodsSpringBootApplication.class, args);
		//get bean object
		service=ctx.getBean("empService", EmployeeService.class);
		//invoke method
		System.out.println("....................................................");
		System.out.println("Total Employee :: "+service.fetchAllEmployeeCount());
		//invoke method
		System.out.println("\n.....................................................");
		System.out.println("Employee name :: "+service.fetchEmployeeData(7499));
		//invoke method
		System.out.println("\n........................ Employee Details..........................");
		System.out.println(service.fetchOneEmployeeDetails(7499));
		//invoke method
		System.out.println("\n........................ All Employee Details..........................");
		System.out.println(service.fetchAllEmployeeDetails());
		//invoke method
		System.out.println("\n........................ All Employee Details by Job..........................");
		System.out.println(service.fetchAllEmployeeDetailsByDesg("CLERK", "MANAGER"));
		//invoke method
		System.out.println("\n..................................................");
		//System.out.println(service.createNewEmployeeRecord(1515, "GANESH", "CLERK", 3000.0f));
		
		/*try {
			//invoke method
			System.out.println("....................................................");
			System.out.println(service.changeEmployeeSalaryByPercentage(1500.0f, 20.0f));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}*/
		/*try {
			//invoke method
			System.out.println("....................................................");
			System.out.println(service.removeEmployeeByNo(1515));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}*/
		
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
