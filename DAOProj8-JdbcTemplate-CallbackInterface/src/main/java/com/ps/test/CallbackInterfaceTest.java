package com.ps.test;

import static java.lang.System.out;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.dto.StudentDTO;
import com.ps.service.StudentManagementService;

public class CallbackInterfaceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentManagementService service=null;
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null,listDTO1=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get bean 
		service=ctx.getBean("studService", StudentManagementService.class);
		//use service and invoke method
		dto=service.fetchStudentRecordByNo(27);
		if(dto!=null) {
			out.println("--------------------------Student Details-(1)----------------------");
			out.println("SNO   NAME    ADDRS       AVG     TOTAL    RESULT  ");
			out.println("---------------------------------------------------------------------");
			out.println(dto.getSno()+"   "+dto.getName()+"   "+dto.getAddrs()+"   "+dto.getAvg()+"   "+dto.getTotal()+"   "+dto.getResult());
		}
		else
			out.print("Record not found.");
		
		System.out.println(".........................................................................................................................");
		System.out.println();
		try {
			//use service and invoke method
			listDTO=service.fetchStudentRecordByAddrs("Muz");
			
				out.println("--------------------------Student Details-(2)----------------------");
				
				//##display each student details using forEach loop java8 feature
				/*listDTO.forEach(dto1->{
					out.println(dto1);
					//out.println(dto1.getSrNo()+"   "+dto1.getSno()+"   "+dto1.getName()+"   "+dto1.getAddrs()+"   "+dto1.getAvg()+"   "+dto1.getTotal()+"   "+dto1.getResult());
				});*/
				
				//##display each student using stream java8 feature
				/*listDTO.stream().forEach(dto1->{
					out.println(dto1);
				});*/
				
				//##display each student using method reference java8 feature
				listDTO.forEach(out::println);
				
				//##Filter + stream api + method reference using from java 8 feature
				//listDTO.stream().filter((avg)->avg.getAvg()>70).forEach(out::println);
				
				//##display each student using method reference and stream java8 feature
				//listDTO.stream().forEach(out::println);
				
				//##display each student using collect(-) java8 feature
				//out.println(listDTO.stream().collect(Collectors.toList()));	//using List Collection
				//out.println(listDTO.stream().collect(Collectors.toSet()));	//using Set Collection
				
				/*out.println(listDTO);
				out.println("--------------------------------------------------------------------------------------");
				Set<StudentDTO> setDTO=listDTO.stream().collect(Collectors.toSet());		//converting List Collection to Set Collection
				out.println(setDTO);*/

				out.println("--------------------------Student Details-(3)----------------------");
				listDTO1=service.fetchStudentRecordByCity("Muz");
				listDTO1.forEach(out::println);

		}//try
		catch(Exception e) {
			e.printStackTrace();
		}		
		
	}//main

}//class
